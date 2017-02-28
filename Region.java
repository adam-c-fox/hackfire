class Region {
    Boolean onFire;
    Double probabilityOfFire;
    Color[] statecolor={Color.black,Color.white};
    
    Region(){
        if (onFire == true){
           Color = statecolor[1];
        }else {
           Color = statecolor[0];
        }      
    }
}
