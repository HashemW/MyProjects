// Fill out your copyright notice in the Description page of Project Settings.


#include "Grabber.h"
#include "Engine/World.h"
#include "DrawDebugHelpers.h"
#include "PhysicsEngine/PhysicsHandleComponent.h"

// Sets default values for this component's properties
UGrabber::UGrabber()
{
	// Set this component to be initialized when the game starts, and to be ticked every frame.  You can turn these features
	// off to improve performance if you don't need them.
	PrimaryComponentTick.bCanEverTick = true;

	// ...
}


// Called when the game starts
void UGrabber::BeginPlay()
{
	Super::BeginPlay();
	UPhysicsHandleComponent* PhysicsHandle = GetPhysicsHandle();
	if (PhysicsHandle != nullptr) {
		UE_LOG(LogTemp, Display, TEXT("Name : %s"), *PhysicsHandle->GetName());
	}
	// ...
	
}


// Called every frame
void UGrabber::TickComponent(float DeltaTime, ELevelTick TickType, FActorComponentTickFunction* ThisTickFunction)
{
	Super::TickComponent(DeltaTime, TickType, ThisTickFunction);
	UPhysicsHandleComponent* PhysicsHandle = GetPhysicsHandle();
	if (PhysicsHandle->GetGrabbedComponent() != nullptr) {
		FVector TargetLocation = GetComponentLocation() + GetForwardVector() * HoldDistance;
		PhysicsHandle->SetTargetLocationAndRotation(TargetLocation, GetComponentRotation());
	}
	

}

void UGrabber::Grab() {
	UPhysicsHandleComponent* PhysicsHandle = GetPhysicsHandle();
	if (PhysicsHandle != nullptr) {
		FHitResult HitResult;
		bool HasHit = GetGrabbableInReach(&HitResult);
		if (HasHit) {
			UPrimitiveComponent *HitComponent = HitResult.GetComponent();
			HitComponent->WakeAllRigidBodies();
			HitResult.GetActor()->Tags.Add("Grabbed");
			PhysicsHandle->GrabComponentAtLocationWithRotation(
				HitResult.GetComponent(), 
				NAME_None, 
				HitResult.ImpactPoint, 
				GetComponentRotation());
		}
		else {
			UE_LOG(LogTemp, Display, TEXT("No Actor Hit"));
		}
	}
}

bool UGrabber::GetGrabbableInReach(FHitResult *HitResult) {
	FCollisionShape Sphere = FCollisionShape::MakeSphere(GrabRadius);
	FVector Start = GetComponentLocation();
	FVector End = Start + GetForwardVector() * MaxGrabDistance;
	return GetWorld()->SweepSingleByChannel (
			*HitResult, 
			Start, End, 
			FQuat::Identity, 
			ECC_GameTraceChannel2,
			Sphere
		);
}
void UGrabber::Release() {
	UPhysicsHandleComponent *PhysicsHandle = GetPhysicsHandle();
	FHitResult HitResult;
	bool HasHit = GetGrabbableInReach(&HitResult);
	if (PhysicsHandle == nullptr) {
		return;
	} else if (PhysicsHandle->GetGrabbedComponent() != nullptr) {
		HitResult.GetActor()->Tags.Remove("Grabbed");
		PhysicsHandle->GetGrabbedComponent()->WakeAllRigidBodies();
		PhysicsHandle->ReleaseComponent();
	}
}

UPhysicsHandleComponent *UGrabber::GetPhysicsHandle() const {
	return GetOwner()->FindComponentByClass<UPhysicsHandleComponent>();
}
