package ApiEndpoints;

/* Create users (Post): https://petstore.swagger.io/v2/user */
/* Get users (Get): https://petstore.swagger.io/v2/user/{username} */
/* Update users (PUT): https://petstore.swagger.io/v2/user/{username} */
/* Delete users (Delete: https://petstore.swagger.io/v2/user/{username}) */

public class Routers {

    public static String base_url = "https://petstore.swagger.io/v2";

    /* User Module */

    public static String post_url = base_url + "/user";
    public static String get_url = base_url + "/user/{username}";
    public static String update_url = base_url + "/user/{username}";
    public static String delete_url = base_url + "/user/{username}";
    
    /* Store module */
        /* here you will create store module url's */

    /* Pet module */
        /* here you will create pet module url's */
}
