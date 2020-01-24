

public class TheMainClass {
    public static void main(String[] args) throws InterruptedException {

        Thread t1 = new Thread(new DownloadThePrediction());
        UserInteraction userInteraction = new UserInteraction();
        Thread t2 = new Thread(userInteraction);

        t1.start();
        t2.start();

        if(t1.isAlive()){ t1.join();}
        if(t2.isAlive()){t2.join();}

        if(userInteraction.getDayOfBirth()!=0 && userInteraction.getHeight()!=0)knowYourDestiny(userInteraction);

    }

    private static void knowYourDestiny(UserInteraction userInteraction){
        StringBuilder finMessage = new StringBuilder();
        char delimiter;
        int size = DownloadThePrediction.magicWords.length;
        int formula = (int) Math.abs(Math.random()*(size/9)+userInteraction.getDayOfBirth()-userInteraction.getHeight()%11);
        //System.out.println(formula);
        try{
            for (int i = formula; i < size; i+=size/10+formula%3) {
                while(DownloadThePrediction.magicWords[i].length()<6){ i++;}
                if(i%3==0){delimiter = ',';}
                else if(i%7==0){delimiter = '-';}
                else {delimiter=' ';}
                finMessage.append(DownloadThePrediction.magicWords[i]).append(delimiter);
            }
            finMessage.replace(finMessage.length()-1,finMessage.length(),".");
        }catch (ArrayIndexOutOfBoundsException ignored){}

        System.out.println("Ваше будущее описывается следующими словами:\n" + finMessage.toString());
    }

}
