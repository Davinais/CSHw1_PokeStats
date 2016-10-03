import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.lang.Math;

/*處理關於寶可夢能力值方面函數的類別，
其中讀取輸入值部分參考自Example所附之ConsoleIn.java，並挑選有使用到的函式並改寫成寶可夢能力值輸入專用之形式。*/

public class PokemonStats
{
    private static final BufferedReader inputObject = new BufferedReader(new InputStreamReader(System.in));

    //讀取字串用函式，處理完IO例外的部分。
    public static String readLine()
    {
        String input = null;
        try
        {
            input = inputObject.readLine();
        }
        catch(IOException err)
        {
            System.out.println("發生嚴重錯誤，離開程式…");
            System.exit(0);
        }
        return input;
    }

    //讀取寶可夢能力值專用函式，限制使用者只能輸入0~15之間的數字。
    public static int readPokeStats()
    {
        String input = null;
        int stats = 0;
        Boolean pass = false;
        while(!pass)
        {
            try
            {
                input = readLine();
                stats = Integer.parseInt(input);
                //判斷是否落在0~15區間內，若否則扔出NumberFormat例外。
                if(stats < 0 || stats > 15)
                {
                    throw new NumberFormatException();
                }
                else
                {
                    pass = true;
                }
            }
            catch(NumberFormatException err)
            {
                System.out.println("輸入型態錯誤！");
                System.out.println("輸入值必須為0~15之間的整數，");
                System.out.print("請重新輸入能力值：");
            }
        }
        return stats;
    }

    //讀取計算系統選項用函式，限制只能輸入0~3之間的byte。
    public static byte readChoice()
    {
        String input = null;
        byte choice = 0;
        Boolean pass = false;
        while(!pass)
        {
            try
            {
                input = readLine();
                choice = Byte.parseByte(input);
                //判斷是否落在0~3區間內，若否則扔出NumberFormat例外。
                if(choice < 0 || choice > 3)
                {
                    throw new NumberFormatException();
                }
                else
                {
                    pass = true;
                }
            }
            catch(NumberFormatException err)
            {
                System.out.println("輸入型態錯誤！");
                System.out.println("輸入值必須為0~3之間的選項，");
                System.out.println("請重新輸入想要進行的動作，");
                System.out.print(">>> ");
            }
        }
        return choice;
    }

    //讀入ATK, DEF, STA 參數，並使用IV值公式：(ATK+DEF+STA)/45*100%，以計算IV值。
    public static int calcIV(int atk, int def, int sta)
    {
        return (int)Math.floor((atk + def + sta)/45.0*100); //將45寫成45.0，如此一來除法之商即會是double而不會是int
    }

    //評價IV值的高低。
    public static void appraiseIV(int iv)
    {
        String appraise = null;
        if(iv >= 75)
        {
            appraise = "極佳";
        }
        else if(iv >= 50)
        {
            appraise = "優良";
        }
        else if(iv >= 25)
        {
            appraise = "稍差";
        }
        else
        {
            appraise = "極差";
        }
        System.out.println("本隻寶可夢的評價為：【"+appraise+"】");
    }
}