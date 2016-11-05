package P07_Dijkstra;

/**
 * @author Stefan Epprecht <epprest1@students.zhaw.ch>
 * @author Lawrence Markwalder <markwlaw@students.zhaw.ch>
 * @author Luca Egli <eglilu01@students.zhaw.ch>
 *
 * Source: https://stackoverflow.com/questions/15380243/how-to-retrieve-enum-name-using-the-id
 */
public enum City {
    Winterthur(0),
    Zuerich(1),
    Bern(2),
    Luzern(3),
    Chur(4),
    Berikon(5),
    Genf(6),
    Lugano(7);

    private Integer id;

    City(int id) {
        this.id = id;
    }

    public int getId(){
        return id;
    }

    public static String getName(int id) {
        for(City e : values()) {
            if(e.id.equals(id)){
                return e.name();
            }
        }
        return null;
    }
}
