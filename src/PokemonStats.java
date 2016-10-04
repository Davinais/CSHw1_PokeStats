import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

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

    //讀取寶可夢等級專用函式，限制使用者只能輸入1~40之間的整數。
    public static int readPokeLevel()
    {
        String input = null;
        int level = 0;
        Boolean pass = false;
        System.out.print("為計算CP值，請輸入寶可夢等級：");
        while(!pass)
        {
            try
            {
                input = readLine();
                level = Integer.parseInt(input);
                //判斷是否落在1~40區間內，若否則扔出NumberFormat例外。
                if(level < 1 || level > 40)
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
                System.out.println("輸入值必須為1~40之間的整數，");
                System.out.print("請重新輸入等級：");
            }
        }
        return level;
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

    /*計算寶可夢的CP值，使用CP值公式：(ATK+100)*(DEF+100)*(STA+100)*(等級換算值)^2/1000，
    其中等級換算值=0.0175*等級+0.09
    */
    public static int calcCP(int atk, int def, int sta, int level)
    {
        double levelConv = 0.0175*level+0.09;
        return (int)Math.floor(((atk+100)*(def+100)*(sta+100)*(levelConv*levelConv))/1000.0);
    }
}
