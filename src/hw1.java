public class hw1
{
    public static void menuDisplay()
    {
        System.out.println("════════════════════════════");
        System.out.println("請選擇想要進行的動作：");
        System.out.println("[0] 離開系統");
        System.out.println("[1] 計算IV值");
        System.out.println("[2] 計算特定等級之CP值");
        System.out.println("[3] 計算目標CP值之最低等級");
        System.out.print(">>> ");
    }
    public static void main(String[] args)
    {
        System.out.println("歡迎使用寶可夢能力值計算系統");
        System.out.println("════════════════════════════\n");
        System.out.print("請輸入寶可夢個體攻擊(ATK)數值：");
        int atk = PokemonStats.readPokeStats();
        System.out.print("請輸入寶可夢個體防禦(DEF)數值：");
        int def = PokemonStats.readPokeStats();
        System.out.print("請輸入寶可夢個體體力(STA)數值：");
        int sta = PokemonStats.readPokeStats();
        Boolean end = false;
        while(!end)
        {
            menuDisplay();
            byte choice = PokemonStats.readChoice();
            switch(choice)
            {
                case 0:
                    System.out.println("感謝使用本計算系統，下次再見～");
                    System.exit(0);
                    break;
                case 1:
                    int iv = PokemonStats.calcIV(atk, def, sta);
                    System.out.println("IV值為：" + iv + "%");
                    PokemonStats.appraiseIV(iv);
                    break;
                case 2:
                case 3:
                default:
                    System.out.println("發生錯誤，結束程式…");
                    System.exit(0);
            }
        }
    }
}