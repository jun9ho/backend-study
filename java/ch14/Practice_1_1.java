package ch14;

public class Practice_1_1 {
    public static void main(String[] args) {
        HybridWaterCar Car = new HybridWaterCar(10,20,30);
        Car.showCurrentGauge();
        HybridWaterCar Car1 = new HybridWaterCar();
        Car1.showCurrentGauge();
    }
}

class Car {
    int gasolineGauge;

    public Car() {
        System.out.println("CAR CLASS");
    }

    public Car(int gasolineGauge) {
        this.gasolineGauge = gasolineGauge;
        System.out.println("CAR CLASS");
    }
}

class HybridCar extends Car {
    int electricGauge;
    
    public HybridCar()
    {
        super();
        System.out.println("HybridCar CLASS");
    }

    public HybridCar(int gasolineGauge, int electricGauge) {
        super(gasolineGauge);
        this.electricGauge = electricGauge;
        System.out.println("HybridCar CLASS");
    }
}

class HybridWaterCar extends HybridCar {
    int waterGauge;

    public HybridWaterCar()
    {
        super();
        System.out.println("HybridWaterCar CLASS");
    }

    public HybridWaterCar(int gasolineGauge, int electricGauge, int waterGauge)
    {
        super(gasolineGauge, electricGauge);
        this.waterGauge = waterGauge;
        System.out.println("HybridWaterCar CLASS");
    }

    public void showCurrentGauge() {
        System.out.println("잔여 가솔린: " + gasolineGauge);
        System.out.println("잔여 전기량: " + electricGauge);
        System.out.println("잔여 워터량: " + waterGauge);
    }
}
