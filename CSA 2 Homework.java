"""
    Question 3
""";

public class Crossword{

    private Square[][] puzzle;

    private boolean toBeLabeled(int r, int c, boolean[][] blackSquares){
        """
            True: Labeled with Positive Number
            else{False}
        """;
        if (blackSquares[r][c]){
            return false;
        }
        else if (r == 0 || c == 0 || r = blackSquares.length || c == blackSquares[0].length){
            return true;
        }        
        else if (blackSquares[r - 1][c] || blackSquares[r][c - 1]){
            return true;
        }
    }

    public Crossword(boolean[][] blackSquares){
        int count = 1;
        Square[][] puzzle = new Square[blackSquares.length][blackSquares[0].length]
        for (int r = 0; r < blackSquares.length; r++){
            for (int c = 0; c < blackSquares[0].length; c++){
                if (!toBeLabeled(r, c, blackSquares)){
                    if (blackSquares[r][c]){
                        puzzle[r][c] = new Square(true, 0);
                    }
                    else{
                    puzzle[r][c] = new Square(toBeLabeled(r, c, blackSquares), 0);
                }
                }
                else if (toBeLabeled(r, c, blackSquares)){
                    puzzle[r][c] = new Square(!toBeLabeled(r, c, blackSquares), count);
                    count++;
                }
            }
        }
    }
}   

-------------------------------------

"""
    Question 4
""";

public class StringFormatter{
    public StringFormatter(){
        """
            N/A
        """;
    }
    public static int totalLetters(List<String> wordList){
        int count = 0;
        for (int i = 0; i < wordList.size(); i ++){
            String word = wordList.get(i);
            count += word.length();
        }
        return count;
    }
    public static int basicGapWidth(List<String> wordList, int formattedLen){
        int num_letters = totalLetters(wordList);
        if (wordList.size() == 2){
            return formattedLen - num_letters;
        }
        else{
            int res_len = formattedLen - num_letters;
            int ratio = (int)(res_len / (wordList.size() - 1));
            return ratio;
        }
    }

    public static String format(List<String> wordList, int formattedLen){
        int bGW = basicGapWidth(wordList, formattedLen);
        int total_letters = totalLetters(wordList);
        int left_over = leftoverSpaces(wordList, formattedLen);

        String combined_word = wordList.get(0);
        for (int i = 1; i < wordList.size(); i++){
            word = wordList.get(i);
            for (int j = 0; j < bGW; j++){
                combined_word += " ";
            }
            combined_word += " ";
            left_over--;
            combined_word += word;
        }
        return combined_word;
    }
}