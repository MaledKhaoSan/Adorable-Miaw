




public class CatCreated {
    private final String[] CatPath = {
            "src/resource/typing_game/CatSpriteSheet1.png",
            "src/resource/typing_game/CatSpriteSheet2.png",
            "src/resource/typing_game/CatSpriteSheet3.png"
    };
    public CatAnimated CatGetType(int CatType){
        if (CatType == 0){
            return CatSelected(new CatWalking(CatPath[CatType]));
        }
        else if (CatType == 1){
            return CatSelected(new CatWalking(CatPath[CatType]));
        }
        return CatSelected(new CatPlaying(CatPath[CatType]));
    }
    public CatAnimated CatSelected(CatAnimated animated) {
        return animated;
    }
}
