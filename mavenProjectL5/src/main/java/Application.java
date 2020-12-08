import dao.Dao;
import dao.DaoType;
import dao.Exception.DaoException;
import dao.impl.CarDaoFactory;
import domain.Car;

public class Application {
    public static void main(String[] args) {
        CarDaoFactory carDaoFactory = new CarDaoFactory();
        Dao<Car> dao = carDaoFactory.getDao(DaoType.DATABASE);

        Car car = new Car();
        car.setVin("1");
        car.setColor("Black");
        car.setModel("VW");
        car.setPrice(12.1);

        try {
            dao.insert(car);
        } catch (DaoException e){
        }
    }
}
