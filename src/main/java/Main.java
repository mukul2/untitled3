import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.util.Map;

import com.google.gson.Gson;

public class Main {

    public static void main(String[] args) {
        ScapegoatTree<String, Object> sgt = new ScapegoatTree<>();
        Gson gson = new Gson();
        try (Reader reader = new FileReader("src/WildKrattsDB.json")) {
            Map<?, ?> map = gson.fromJson(reader, Map.class);
            for (Map.Entry<?, ?> entry : map.entrySet()) {
                sgt.insert(entry.getKey().toString(), entry.getValue());
             //  System.out.println(entry.getKey() + "=" + entry.getValue());
              System.out.println(entry.getKey() + "=" + entry.getValue());
               // System.out.println(entry.getValue().getClass().getName());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println(sgt);
        
        System.out.println("\n<-----------------In Order -------------------------->");
        sgt.inOrder();
       System.out.println("\n<-----------------Post Order -------------------------->");
        sgt.postorder();
       System.out.println("\n<-----------------Pre Order -------------------------->");
       sgt.preorder();
       
       System.out.println("\n<-----------------override tostring using mutable String (preorder)-------------------------->"); 
       StringBuilder rep=new StringBuilder();
       sgt.toString(rep);
       
       System.out.println("\n<-----------------Predeccessor of S01E16-------------------------->");
        sgt.predecessor("S01E16");
        
        System.out.println("\n<-----------------successor of S01E16-------------------------->");
        sgt.successor("S01E16");
        
       
        
    }
}
