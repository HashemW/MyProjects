// Fill out your copyright notice in the Description page of Project Settings.

#include "ToonTanksGameMode.h"
#include "Kismet/GameplayStatics.h"
#include "Tower.h"
#include "Tank.h"
#include "ToonTanksPlayerController.h"

void AToonTanksGameMode::ActorDied(AActor *DeadActor) {
    if (DeadActor == Tank) {
        Tank->HandleDestruction();
        if (Tank->GetTankPlayerController()) {
            ToonTanksPlayerController->SetPlayerEnabledState(false);
        }
        GameOver(false);
    } else if (ATower *DestroyedTower = (ATower *) DeadActor) {
        DestroyedTower->HandleDestruction();
        TowerCount--;
        if (TowerCount == 0) {
            GameOver(true);
        }
    }
}

void AToonTanksGameMode::BeginPlay() {
    Super::BeginPlay();

    HandleGameStart();
}

void AToonTanksGameMode::HandleGameStart() {
    Tank = (ATank*) UGameplayStatics::GetPlayerPawn(this, 0);
    ToonTanksPlayerController = (AToonTanksPlayerController*) UGameplayStatics::GetPlayerController(this, 0);
    StartGame();
    if (ToonTanksPlayerController) {
        ToonTanksPlayerController->SetPlayerEnabledState(false);
        FTimerHandle PlayerEnableTimerHandle;
        FTimerDelegate PlayerEnableTimerDelegate = FTimerDelegate::CreateUObject(ToonTanksPlayerController, 
            &AToonTanksPlayerController::SetPlayerEnabledState, true);
        GetWorldTimerManager().SetTimer(PlayerEnableTimerHandle, PlayerEnableTimerDelegate, StartDelay, false);
    }
} 