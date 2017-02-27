class Region {
    Boolean onFire;
    Double probabilityOfFire;
    public Color[] statecolor={Color.black,Color.white};
    
    Region(){
        if (onFire == true){
           Color = statecolor[1];
        }else {
           Color = statecolor[0];
        }      
    }
}
