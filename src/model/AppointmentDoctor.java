package model;

import java.util.Date;

public class AppointmentDoctor implements IScheduable {
    private int id;
    private Patient patient;
    private Doctor doctor;
    private Date date;
    private String time;

    @Override
    public void schedule(Date date, String time) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'schedule'");
    }

}
