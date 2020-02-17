import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class ParkingLotRepositoryTest {

    ParkingVehicle parkedVehicle = null;
    ParkingLot parkingLot = null;

    @Before
    public void setup() {
        parkedVehicle = new ParkingVehicle();
        parkingLot = new ParkingLot(4, 2);
    }

    @Test
    public void whenVehicleArrives_shouldParkInLot() {
        boolean carParkStatus = parkingLot.getVehicleParked(parkedVehicle);
        ParkingVehicle parkedVehicle1 = new ParkingVehicle();
        Assert.assertTrue(carParkStatus);
    }

    @Test
    public void givenSameCarToPark_thenReturnException() {
        try {
            boolean carParkStatus = parkingLot.getVehicleParked(parkedVehicle);
            boolean carParkStatus1 = parkingLot.getVehicleParked(parkedVehicle);
        } catch (ParkingLotException e){
            Assert.assertEquals(ParkingLotException.ExceptionType.VEHICLE_ALREADY_PARKED, e.type);
        }
    }

    @Test
    public void whenDriverArrives_shouldUnparkVehicle() {
        ParkingVehicle parkedVehicle = new ParkingVehicle();
        boolean carParkStatus = parkingLot.getVehicleParked(parkedVehicle);
        boolean carUnParkStatus = parkingLot.getVehicleUnparked(parkedVehicle);
        Assert.assertTrue(carUnParkStatus);
    }

    @Test
    public void whenGivenInvalidCarNumber_shouldThrowException() {
        try {
            boolean carParkStatus = parkingLot.getVehicleParked(parkedVehicle);
            boolean carUnParkStatus = parkingLot.getVehicleUnparked(parkedVehicle);
        } catch (ParkingLotException e) {
            Assert.assertEquals(ParkingLotException.ExceptionType.NO_SUCH_VEHICLE_NUMBER, e.type);
        }
    }

    @Test
    public void whenMoreVehicleThenAvailableLotSize_shouldSetParkingLotStatusFull() {
        boolean carParkStatus = parkingLot.getVehicleParked(parkedVehicle);
        ParkingVehicle parkedVehicle1 = new ParkingVehicle();
        boolean carParkStatus1 = parkingLot.getVehicleParked(parkedVehicle1);
        ParkingVehicle parkedVehicle2 = new ParkingVehicle();
        boolean carParkStatus2 = parkingLot.getVehicleParked(parkedVehicle2);
        ParkingVehicle parkedVehicle3 = new ParkingVehicle();
        boolean carParkStatus3 = parkingLot.getVehicleParked(parkedVehicle3);
        ParkingVehicle parkedVehicle4 = new ParkingVehicle();
        boolean carParkStatus4 = parkingLot.getVehicleParked(parkedVehicle4);
        Assert.assertTrue(new ParkingLotOwner().isParkingLotFull);
    }

    @Test
    public void whenParkingLotStatusFull_shouldSetSecurityStaffStatusFull() {
        boolean carParkStatus = parkingLot.getVehicleParked(parkedVehicle);
        ParkingVehicle parkedVehicle1 = new ParkingVehicle();
        boolean carParkStatus1 = parkingLot.getVehicleParked(parkedVehicle1);
        ParkingVehicle parkedVehicle2 = new ParkingVehicle();
        boolean carParkStatus2 = parkingLot.getVehicleParked(parkedVehicle2);
        ParkingVehicle parkedVehicle3 = new ParkingVehicle();
        boolean carParkStatus3 = parkingLot.getVehicleParked(parkedVehicle3);
        ParkingVehicle parkedVehicle4 = new ParkingVehicle();
        boolean carParkStatus4 = parkingLot.getVehicleParked(parkedVehicle4);
        Assert.assertTrue(new AirportSecuritySystem().isParkingLotFull);
    }

    @Test
    public void whenMoreThen100Vehicle_ifAnyVehicleUnparked_shouldSetParkingLotStatusNotFull() {
        ParkingVehicle parkedVehicle1 = new ParkingVehicle();
        boolean carParkStatus = parkingLot.getVehicleParked(parkedVehicle);
        boolean carParkStatus1 = parkingLot.getVehicleParked(parkedVehicle1);
        boolean carUnparkStatus = parkingLot.getVehicleUnparked(parkedVehicle);
        Assert.assertFalse(new ParkingLotOwner().isParkingLotFull);
    }

    @Test
    public void whenParkingLotStatusFull_shouldSetSecurityStaffStatusNotFull() throws InterruptedException {
        ParkingVehicle parkedVehicle1 = new ParkingVehicle();
        boolean carParkStatus = parkingLot.getVehicleParked(parkedVehicle);
        boolean carParkStatus1 = parkingLot.getVehicleParked(parkedVehicle1);
        boolean carUnparkStatus = parkingLot.getVehicleUnparked(parkedVehicle);
        Assert.assertFalse(new AirportSecuritySystem().isParkingLotFull);
    }

    @Test
    public void whenGivenParkingVehicle_shouldReturnSlotNumber() {
        boolean carParkStatus = parkingLot.getVehicleParked(parkedVehicle);
        boolean carParkStatus1 = parkingLot.getVehicleParked(new ParkingVehicle());
        boolean carParkStatus2 = parkingLot.getVehicleParked(new ParkingVehicle());
        Integer slotNumber = parkingLot.findVehicle(parkedVehicle);
        System.out.println(slotNumber);
        Assert.assertEquals("1", "" + slotNumber);
    }

    @Test
    public void whenGivenParkingVehicle_shouldReturnTimeParked() {
        boolean carParkStatus = parkingLot.getVehicleParked(parkedVehicle);
        boolean carUnparkStatus = parkingLot.getVehicleUnparked(parkedVehicle);
        Assert.assertEquals(parkedVehicle.getLocalDateTime(), new ParkingLotOwner().getVehicleParkingTime());
    }

    @Test
    public void whenVehicleArrives_shouldParkInLotEvenly() {
        boolean carParkStatus = parkingLot.getVehicleParked(parkedVehicle);
        ParkingVehicle parkedVehicle1 = new ParkingVehicle();
        boolean carParkStatus1 = parkingLot.getVehicleParked(parkedVehicle1);
        ParkingVehicle parkedVehicle2 = new ParkingVehicle();
        boolean carParkStatus2 = parkingLot.getVehicleParked(parkedVehicle2);
        Assert.assertTrue(carParkStatus && carParkStatus1 && carParkStatus2);
    }

    @Test
    public void givenHandicapDriver_whenVehicleToBeParked_thenParkToNearestSlot() {
        boolean carParkStatus = parkingLot.getVehicleParked(parkedVehicle);
        ParkingVehicle parkedVehicle1 = new ParkingVehicle();
        boolean carParkStatus1 = parkingLot.getVehicleParked(parkedVehicle1);
        ParkingVehicle parkedVehicle2 = new ParkingVehicle();
        parkedVehicle2.isHandicap = true;
        boolean carParkStatus2 = parkingLot.getVehicleParked(parkedVehicle2);
        Assert.assertTrue(carParkStatus && carParkStatus1 && carParkStatus2);
    }
}