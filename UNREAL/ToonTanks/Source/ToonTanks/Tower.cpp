// Fill out your copyright notice in the Description page of Project Settings.


#include "Tower.h"
#include "Tank.h"
#include "TimerManager.h"
#include "Kismet/GameplayStatics.h"

void ATower::Tick(float DeltaTime) {
    Super::Tick(DeltaTime);
    if (Tank != NULL) {
        float Distance = FVector::Dist(GetActorLocation(), Tank->GetActorLocation());
        if (Distance <= FireRange) {
            RotateTurret(Tank->GetActorLocation());
        }
    }
    

}

void ATower::HandleDestruction() {
    Super::HandleDestruction();
    Destroy();
}
void ATower::BeginPlay() {
    Super::BeginPlay();
    Tank = (ATank *) UGameplayStatics::GetPlayerPawn(this, 0);
    GetWorldTimerManager().SetTimer(FireRateTimerHandle, this, &ATower::CheckFireCondition, FireRate, true);
}

void ATower::CheckFireCondition() {
    if (Tank != NULL) {
        float Distance = FVector::Dist(GetActorLocation(), Tank->GetActorLocation());
        
        if (Distance <= FireRange) {
            Fire();
        }
    }
}