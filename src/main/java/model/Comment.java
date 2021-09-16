package model;

import lombok.Data;
import org.bson.types.ObjectId;
import utils.MyTime;

<<<<<<< HEAD
=======

>>>>>>> github/master
import java.util.Date;

@Data
public class Comment {
    private ObjectId id;
<<<<<<< HEAD

    private String text;
    private Date date;
    private String email;
    private String name;
    private ObjectId movie_id;
=======
    private String name;
    private String email;
    private String text;
    private ObjectId movie_id;
    private Date date;
>>>>>>> github/master

    public String getTimeAgo() {
        return MyTime.timeAgo(new Date(), date);
    }
<<<<<<< HEAD
}
=======
}
>>>>>>> github/master
