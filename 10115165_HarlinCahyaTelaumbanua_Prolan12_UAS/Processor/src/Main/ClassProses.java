package Main;

import java.util.ArrayList;


public class ClassProses {
    
    private ArrayList<Object> Array = new ArrayList<Object>();
    
    public ClassProses(){}
    
    public ClassProses(ArrayList<Object> Array ){
        this.Array  = Array ;
    }
    
    public void Save(ClassData point){
        this.Array .add(point);
    }

    public void Edit(int index, ClassData point){
        this.Array .set(index, point);
    }
    
    public void Delete(int index){
        this.Array .remove(index);
    }
    
    public ClassData CountArray(int index){
        return (ClassData)Array .get(index);
    }
    
    public int CountSizeArray(){
        return this.Array .size();
    }
    
    public int CariKode(int Nomor){
        for(int i = 0; i < CountSizeArray(); i++){
            if(Nomor == CountArray(i).getID())return i;
        }
        return -1;
    }
    
}
