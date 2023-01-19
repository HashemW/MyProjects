// Fill out your copyright notice in the Description page of Project Settings.

#pragma once

#include "CoreMinimal.h"
#include "BasePawn.h"
#include "Tank.generated.h"

/**
 * 
 */
UCLASS()
class TOONTANKS_API ATank : public ABasePawn
{
	GENERATED_BODY()
	
	public:
		ATank();
		// Called to bind functionality to input, this function allows us to handle input
		virtual void SetupPlayerInputComponent(class UInputComponent* PlayerInputComponent) override;
			// Called every frame
		virtual void Tick(float DeltaTime) override;
		void HandleDestruction();
		APlayerController *GetTankPlayerController() const;
	protected:
		// Called when the game starts or when spawned
		virtual void BeginPlay() override;
	private:
		UPROPERTY(VisibleAnywhere, BlueprintReadOnly, Category = "Components", meta = (AllowPrivateAccess = "true"))
		class USpringArmComponent* SpringArm;
		UPROPERTY(VisibleAnywhere, BlueprintReadOnly, Category = "Components", meta = (AllowPrivateAccess = "true"))
		class UCameraComponent* CameraComponent;
		UPROPERTY(EditAnywhere, BlueprintReadOnly, Category = "Components", meta = (AllowPrivateAccess = "true"))
		float Speed;
		UPROPERTY(EditAnywhere, BlueprintReadOnly, Category = "Components", meta = (AllowPrivateAccess = "true"))
		float Turnrate;
		void Move(float Value);
		void Turn(float Value);
		 
		APlayerController* TankPlayerController;
};


