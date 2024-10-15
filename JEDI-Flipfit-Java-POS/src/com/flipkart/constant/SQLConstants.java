package com.flipkart.constant;

public class SQLConstants {
// CITY
    private static final String SQL_CITY_EXISTS = "SELECT 1 FROM city WHERE cityName = ?";
    private static final String SQL_GET_ALL_CITIES = "SELECT * FROM city";
    private static final String SQL_ADD_CITY = "INSERT INTO city (cityID, cityName) VALUES (?, ?)";


//SLOT
    private static final String SQL_FETCH_SLOTS_BY_GYM_ID = "SELECT * FROM slot WHERE gym_id = ?";
    public static final String UPDATE_CAPACITY = "UPDATE slot SET capacity = capacity + ? WHERE slotID = ?";
    private static final String INSERT_SLOT_SQL =
            "INSERT INTO slot (slotID, starttime, endtime, capacity, gym_id) VALUES (?, ?, ?, ?, ?)";
    private static final String SELECT_SLOT_EXISTS_SQL =
            "SELECT COUNT(*) AS count FROM slot WHERE gym_id = ? AND starttime = ? AND endtime = ?";
    private static final String DELETE_SLOT_SQL =
            "DELETE FROM slot WHERE gym_id = ? AND starttime = ?";
//FlipFitGyms
    private static final String SQL_GET_GYM_CENTERS = "SELECT * FROM FlipFitGyms WHERE city = ?";
    private static final String SQL_GET_PENDING_GYM_CENTERS = "SELECT * FROM FlipFitGyms WHERE gym_status = ?";
    private static final String SQL_GET_ALL_GYM_CENTERS = "SELECT * FROM FlipFitGyms";
    private static final String SQL_APPROVE_GYM_CENTER = "SELECT COUNT(*) FROM FlipFitGyms WHERE gym_id = ?";
    private static final String SQL_UPDATE_GYM_CENTER_STATUS = "UPDATE FlipFitGyms SET gym_status = ? WHERE gym_id = ?";
    private static final String INSERT_GYM_SQL =
            "INSERT INTO FlipFitGyms (gym_id, gym_name, no_of_slots, gym_status, owner_id, city, pincode) VALUES (?, ?, ?, ?, ?, ?, ?)";
    private static final String SELECT_GYMS_BY_OWNER_SQL =
            "SELECT * FROM FlipFitGyms WHERE owner_id = ?";
//FlipFitGymOwner
    private static final String SQL_CHECK_GYM_OWNER = "SELECT COUNT(*) FROM FlipFitGymOwner WHERE userid = ?";
    private static final String SQL_UPDATE_GYM_OWNER_APPROVAL = "UPDATE FlipFitGymOwner SET approval = ? WHERE userid = ?";
    private static final String SQL_GET_PENDING_GYM_OWNERS = "SELECT * FROM FlipFitGymOwner WHERE approval = ?";
    private static final String SQL_GET_ALL_GYM_OWNERS = "SELECT * FROM FlipFitGymOwner";
    private static final String SELECT_GYM_OWNER_SQL =
            "SELECT g.userid, g.username, g.aadhar, g.gst_no, g.pan, u.name, u.email, u.phoneNumber " +
                    "FROM FlipFitGymOwner g JOIN FlipFitUser u ON g.userid = u.userid WHERE u.username = ?";
    private static final String UPDATE_PROFILE_SQL =
            "UPDATE FlipFitGymOwner SET username = ?, name = ?, email = ?, phoneNumber = ?, city = ?, pincode = ?, aadhar = ?, pan = ?, gst_no = ? WHERE userid = ?";
    private static final String INSERT_GYM_OWNER_SQL =
            "INSERT INTO FlipFitGymOwner (username, userid, name, email, phoneNumber, pan, aadhar, gst_no, approval, city, pincode) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";

    //FlipFitCustomer
    private static final String INSERT_CUSTOMER_SQL =
            "INSERT INTO FlipFitCustomer (username, userid, name, email, phoneNumber, city, pincode, approval) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
    private static final String SQL_CHECK_CUSTOMER = "SELECT COUNT(*) FROM FlipFitCustomer WHERE userid = ?";
    private static final String SQL_UPDATE_CUSTOMER_APPROVAL = "UPDATE FlipFitCustomer SET approval = ? WHERE userid = ?";
    private static final String SQL_GET_ALL_CUSTOMERS = "SELECT * FROM FlipFitCustomer";
    private static final String SQL_GET_PENDING_CUSTOMERS = "SELECT * FROM FlipFitCustomer WHERE approval = ?";
    public static final String UPDATE_PROFILE = "UPDATE FlipFitCustomer SET username = ?, name = ?, email = ?, phoneNumber = ?, city = ?, pincode=? WHERE userid = ?";
    public static final String GET_CUSTOMER = "SELECT * FROM FlipFitCustomer WHERE username = ?";
    //Bookings
    public static final String VIEW_BOOKINGS = "SELECT b.bookingID, b.gymID, b.slotID, b.date, gc.gym_name, s.starttime, s.endtime, s.capacity " +
            "FROM booking b " +
            "JOIN FlipFitGyms gc ON b.gymID = gc.gym_id " +
            "JOIN slot s ON b.slotID = s.slotID " +
            "WHERE b.userID = ?";
    public static final String DELETE_BOOKING = "DELETE FROM booking WHERE userID = ? AND slotID = ?";
    public static final String ADD_BOOKING = "INSERT INTO booking (userID, bookingID, gymID, slotID, date) VALUES (?, ?, ?, ?, ?)";
    public static final String BOOKING_EXISTS = "SELECT COUNT(*) FROM booking WHERE slotID = ? AND userID = ?";

    //FlipFitUser

    private static final String INSERT_USER_SQL =
            "INSERT INTO FlipFitUser (userid, name, email, phoneNumber, password, city, pincode, roleId, username) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";
    private static final String UPDATE_USER_SQL =
            "UPDATE FlipFitUser SET username = ?, password = ? WHERE userid = ?";
    private static final String SELECT_USER_SQL =
            "SELECT * FROM FlipFitUser WHERE username = ?";

    //Role
    private static final String INSERT_ROLE_SQL =
            "INSERT INTO role (id, role_name) VALUES (?, ?)";







}
