package bg.garage.email;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import bg.garage.entity.CarEntity;
import bg.garage.repository.CarRepository;
import bg.garage.repository.UserRepository;

@Service("notificationService")
public class NotificationService {

    private String subject = "Notification of vehicle maintenance";
    private String fromAddress = "CarService";
    private Map<Long, String> ownerEmail = new HashMap<>();

    @Autowired
    CarRepository carRepository;

    @Autowired
    UserRepository userrepository;

    @Autowired
    EmailServiceImpl emailServiceImpl;

    @Scheduled(fixedDelay = 1000 * 60 * 60 * 24) // 1000 * 60 * 60 * 24 for 24h
    public void sendNotification() {
        System.out.println("notificationService is call ==>>>>>>>>>>>>>>>");

        // checkCarsByRoadTaxis();
        // checkCarsByAnnualCheck();
        // checkCarsByLiabilityInsurances();
        // checkCarsByFullInsurances();
        // checkCarsByVinettes();

    }

    private void checkCarsByRoadTaxis() {
        Iterable<CarEntity> carsByRoadTaxis = carRepository.findAllByRoadTaxisDeadLine();
        for (CarEntity carEntity : carsByRoadTaxis) {
            String toAddress = getUserEmail(carEntity.getOwnerId());
            String msgBody = "Напомняме ви, че годишният данък на " + carEntity.getMarka() + " " + carEntity.getModel()
                    + " " + carEntity.getRegistrationPlate() + " \n" + "е валиден до "
                    + getFormatedDate(carEntity.getRoadTaxisEndDate());

            sendMail(toAddress, msgBody);
        }
    }

    private void checkCarsByAnnualCheck() {
        Iterable<CarEntity> carsAnnualCheck = carRepository.findAllByAnnualCheckDeadLine();
        for (CarEntity carEntity : carsAnnualCheck) {
            String toAddress = getUserEmail(carEntity.getOwnerId());
            String msgBody = "Напомняме ви, че годишният технически преглед на " + carEntity.getMarka() + " "
                    + carEntity.getModel() + " " + carEntity.getRegistrationPlate() + " \n" + "е валиден до "
                    + getFormatedDate(carEntity.getAnualCheckEndDate());

            sendMail(toAddress, msgBody);
        }
    }

    private void checkCarsByLiabilityInsurances() {
        Iterable<CarEntity> carsLiability = carRepository.findAllByLiabilityDeadLine();
        for (CarEntity carEntity : carsLiability) {
            String toAddress = getUserEmail(carEntity.getOwnerId());
            String msgBody = "Напомняме ви, че застраховката Гражданска Отговорност на " + carEntity.getMarka() + " "
                    + carEntity.getModel() + " " + carEntity.getRegistrationPlate() + " \n" + "е валидна до "
                    + getFormatedDate(carEntity.getLiabilityInsuranseEndDate());

            sendMail(toAddress, msgBody);
        }
    }

    private void checkCarsByFullInsurances() {
        Iterable<CarEntity> carsFullInsurance = carRepository.findAllByFullInsurancesDeadLine();
        for (CarEntity carEntity : carsFullInsurance) {
            String toAddress = getUserEmail(carEntity.getOwnerId());
            String msgBody = "Напомняме ви, че застраховката Авто Каско на " + carEntity.getMarka() + " "
                    + carEntity.getModel() + " " + carEntity.getRegistrationPlate() + " \n" + "е валидна до "
                    + getFormatedDate(carEntity.getFullInsuranseEndDate());

            sendMail(toAddress, msgBody);
        }
    }

    private void checkCarsByVinettes() {
        Iterable<CarEntity> carsVinettes = carRepository.findAllByVinettesDeadLine();
        for (CarEntity carEntity : carsVinettes) {
            String toAddress = getUserEmail(carEntity.getOwnerId());
            String msgBody = "Напомняме ви, че Винетният стикер на " + carEntity.getMarka() + " " + carEntity.getModel()
                    + " " + carEntity.getRegistrationPlate() + " \n" + "е валидна до "
                    + getFormatedDate(carEntity.getVinnetesEndDate());

            sendMail(toAddress, msgBody);
        }
    }

    private String getUserEmail(Long id) {
        String address = ownerEmail.get(id);
        if (address == null) {
            address = userrepository.findOne(id).getEmail();
            ownerEmail.put(id, address);
        }
        return address;
    }

    private String getFormatedDate(Date date) {
        SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
        return formatter.format(date);
    }

    private void sendMail(String toAddress, String msgBody) {
        System.out.println("email send ===>>>>>>>>>>>>>>>>>>>");
        emailServiceImpl.sendEmail(toAddress, fromAddress, subject, msgBody);
    }
}
