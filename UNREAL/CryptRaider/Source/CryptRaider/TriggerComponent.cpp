// Fill out your copyright notice in the Description page of Project Settings.


#include "TriggerComponent.h"

UTriggerComponent::UTriggerComponent()
{
	// Set this component to be initialized when the game starts, and to be ticked every frame.  You can turn these features
	// off to improve performance if you don't need them.
	PrimaryComponentTick.bCanEverTick = true;

	// ...
}

void UTriggerComponent::BeginPlay()
{
	Super::BeginPlay();
	
	// ...
	
}

void UTriggerComponent::TickComponent(float DeltaTime, ELevelTick TickType, FActorComponentTickFunction* ThisTickFunction)
{
	Super::TickComponent(DeltaTime, TickType, ThisTickFunction);
	TArray<AActor*> Actors;
    GetOverlappingActors(Actors);
    if (Mover == nullptr) {
        return;
    }
    if (Actors.Num() > 0) {
        for (AActor *Actor: Actors) {
            if (Actor->ActorHasTag(Tag) && Actor->ActorHasTag("Grabbed") == false) {
                UPrimitiveComponent* Component = Cast<UPrimitiveComponent>(Actor->GetRootComponent());
                if (Component != nullptr) {
                    Actor->AttachToComponent(this, FAttachmentTransformRules::KeepWorldTransform);
                    Component->SetSimulatePhysics(false);
                }
                Mover->SetShouldMove(true);
            };    
        }
        
    } else {
        
        Mover->SetShouldMove(false);
    }
}

void UTriggerComponent::SetMover(UMover *NewMover) {
    Mover = NewMover;
}