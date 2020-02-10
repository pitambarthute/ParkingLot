import java.util.HashMap;
import java.util.Map;

public class ParkingLotRepository {

    static Map<String, Car> parkedCars = new HashMap<>();

    public boolean getVehicleParked(Car[] carDetails) {
        for (int i = 0; i < carDetails.length; i++)
            parkedCars.put(carDetails[i].carNumber, carDetails[i]);
        return true;
    }

    public boolean getVehicleUnparked(String carNumber) {
        if (parkedCars.containsKey(carNumber)) {
            parkedCars.remove(carNumber);
            return true;
        }
        throw new ParkingLotException("Enter valid Car number", ParkingLotException.ExceptionType.NO_SUCH_CAR_NUMBER);
    }
}
