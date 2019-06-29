package com.itheima.constant;

public class LianShi {


    public LianShi then(String then){
        this.then = then;
        return this;
    }

    public LianShi catchZ(String catchZ){
        this.catchZ = catchZ;
        return this;
    }


    private String then;
    private String catchZ;

    public String getThen() {
        return then;
    }

    public void setThen(String then) {
        this.then = then;
    }

    public String getCatchZ() {
        return catchZ;
    }

    public void setCatchZ(String catchZ) {
        this.catchZ = catchZ;
    }

    @Override
    public String toString() {
        return "LianShi{" +
                "then='" + then + '\'' +
                ", catchZ='" + catchZ + '\'' +
                '}';
    }
}
