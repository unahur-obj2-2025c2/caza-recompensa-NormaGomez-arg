package ar.edu.unahur.obj2.profugos;

public class ProteccionLegal extends ProfugoDecorator {

    public ProteccionLegal(IProfugo profugo) {
        super(profugo);
    }

    @Override
    public Integer getInocencia() {
        return Math.max(40, profugo.getInocencia());
    }
    

    
    

}
