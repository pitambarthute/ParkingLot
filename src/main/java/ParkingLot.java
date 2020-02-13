public class ParkingLot {

    private Object[] parkedVehicle;
    private ParkingLotRepository parkingLotRepository = new ParkingLotRepository();
    public static ParkingLotEnum ownerParkingLotStatus = ParkingLotEnum.NOT_FULL;
    public static ParkingLotEnum securityStatus = ParkingLotEnum.NOT_FULL;

    public ParkingLot(Object[] carDetails) {
        this.parkedVehicle = carDetails;
    }

    public ParkingLot(Object[] carDetails, ParkingLotRepository parkingLotRepository) {
        this.parkedVehicle = carDetails;
        this.parkingLotRepository = parkingLotRepository;
    }

    public boolean getVehicleParkedUnparked(Object... unparkVehicle){
        if (unparkVehicle.length == 0)
            return parkingLotRepository.getVehicleParked(parkedVehicle);
        return parkingLotRepository.getVehicleUnparked(unparkVehicle[0]);
    }
}