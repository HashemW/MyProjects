// Fill out your copyright notice in the Description page of Project Settings.
#include "Tank.h"
#include "Camera/CameraComponent.h"
#include "GameFramework/SpringArmComponent.h"
#include "Components/InputComponent.h"
#include "Kismet/GameplayStatics.h"


ATank::ATank() {
    // Spring arm initialized for tank pawn and attached to root component
    SpringArm = CreateDefaultSubobject<USpringArmComponent>(TEXT("Spring Arm"));
    SpringArm->SetupAttachment(RootComponent);
    // camera initialized for tank pawn and attached to the spring arm
    CameraComponent = CreateDefaultSubobject<UCameraComponent>(TEXT("Camera"));
    CameraComponent->SetupAttachment(SpringArm);

}


void ATank::SetupPlayerInputComponent(UInputComponent* PlayerInputComponent) {
    Super::SetupPlayerInputComponent(PlayerInputComponent);

    PlayerInputComponent->BindAxis(TEXT("MoveForward"), this, &ATank::Move);
    PlayerInputComponent->BindAxis(TEXT("Turn"), this, &ATank::Turn);
    PlayerInputComponent->BindAction(TEXT("Fire"), IE_Pressed, this, &ATank::Fire);
}

void ATank::HandleDestruction() {
    Super::HandleDestruction();
    SetActorHiddenInGame(true);
    SetActorTickEnabled(false);
}
void ATank::Move(float Value) {
    FVector DeltaLocation = FVector(0,0,0);
    // X = Value * DeltaTime * Speed 
    DeltaLocation.X = Value * UGameplayStatics::GetWorldDeltaSeconds(this) * Speed;
    AddActorLocalOffset(DeltaLocation, true);
}

void ATank::Tick(float DeltaTime) {
    Super::Tick(DeltaTime);

    if (TankPlayerController) {
        FHitResult HitResult;
        TankPlayerController->GetHitResultUnderCursor(ECollisionChannel::ECC_Visibility, false, HitResult);
        RotateTurret(HitResult.ImpactPoint);
    }
    
}
void ATank::BeginPlay() {
    Super::BeginPlay();
    TankPlayerController = (APlayerController *) GetController();
}
void ATank::Turn(float Value) {
    FRotator DeltaRotation = FRotator::ZeroRotator;
    DeltaRotation.Yaw = Value * Turnrate * UGameplayStatics::GetWorldDeltaSeconds(this);
    AddActorLocalRotation(DeltaRotation, true); 
}

APlayerController* ATank::GetTankPlayerController() const {
    return NULL;
}
