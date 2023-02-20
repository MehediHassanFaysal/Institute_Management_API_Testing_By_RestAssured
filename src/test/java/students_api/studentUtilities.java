package students_api;

public class studentUtilities {
    /* for post() method
    {
            ""f_name"": ""Sarder"",
            ""l_name"": ""Faysal"",
            ""gender"": ""Male"",
            ""age"": 24,
            ""mobile_no"": ""01797651089"",
            ""email"": ""faysal001@gmail.com"",
            ""password"": ""12Abc#12""
    }

    */
    public static String stuFirstName(){
        return "Faysal";
    }

    public static String stuLastName(){
        return "Sarder";
    }

    public static String stuGender(){
        return "Male";
    }

    public static Integer stuAge(){
        return (26);
    }

    public static String stuPhnNo(){
        return "01797651893";
    }

    public static String stuEmail(){
        return "faysal12@yahoo.com";
    }

    public static String stuPass(){
        return "12Abc#12";
    }



    // for put() request method

    public static String UpdateStuFirstName(){return "MD";}

    public static String UpdatestuLastName(){
        return "Faysal";
    }

    public static String UpdatestuGender(){
        return "Male";
    }

    public static Integer UpdatestuAge(){
        return (26);
    }

    public static String UpdatestuPhnNo(){
        return "01397651894";
    }

    public static String UpdatestuEmail(){
        return "faysal13@yahoo.com";
    }

    public static String UpdatestuPass(){
        return "12Abc#123";
    }


    /*  //patch() request
    {
            "f_name": "Faysal",
            "l_name": "Sarder",
            "age": 23
     }
     */

    public static String p_update_stu_firstname(){
        return "Mohammad";
    }
    public static String p_update_stu_lastname(){
        return "Faysal";
    }
    public static Integer p_update_stu_age(){
        return 24;
    }



}
