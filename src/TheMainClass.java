

public class TheMainClass {
    public static void main(String[] args) throws InterruptedException{

        Thread t1 = new Thread(new DownloadThePrediction());
        UserInteraction userInteraction = new UserInteraction();
        Thread t2 = new Thread(userInteraction);

        t1.start();
        t2.start();

        if(t1.isAlive()){ t1.join();}
        if(t2.isAlive()){t2.join();}

        knowYourDestiny(userInteraction);

    }

    private static void knowYourDestiny(UserInteraction userInteraction){
       if(userInteraction.getDayOfBirth()!=0 && userInteraction.getHeight()!=0) {
            StringBuilder finMessage = new StringBuilder();
            char delimiter;
            int size = DownloadThePrediction.magicWords.length;
            int formula = (int) Math.abs(Math.random() * (size*1f / 9) + userInteraction.getDayOfBirth() - userInteraction.getHeight() % 11);

            try {
                for (int i = formula; i < size; i += size / 10 + formula % 3) {
                    while (DownloadThePrediction.magicWords[i].length() < 5) {
                        i++;
                    }
                    if (i % 3 == 0) {
                        delimiter = ',';
                    } else if (i % 7 == 0) {
                        delimiter = '-';
                    } else {
                        delimiter = ' ';
                    }
                    finMessage.append(DownloadThePrediction.magicWords[i]).append(delimiter);
                }
                finMessage.replace(finMessage.length() - 1, finMessage.length(), ".");
            } catch (ArrayIndexOutOfBoundsException ignored) {}

            System.out.println("Ваше будущее описывается следующими словами:\n" + finMessage.toString());
        }

       if(UserInteraction.tryItAgain())
       {
           UserInteraction userInteractionNew = new UserInteraction();
           userInteractionNew.run();
           knowYourDestiny(userInteractionNew);
       }

    }

}
