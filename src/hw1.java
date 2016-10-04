public class hw1
{
    //請求使用者輸入寶可夢的數值，需要一能力值變數以及其名稱作為參數
    public static int statsInput(int stats, String name)
    {
        System.out.print("請輸入寶可夢" + name + "數值：");
        stats = PokemonStats.readPokeStats();
        return stats;
    }
    
    //顯示選單
    public static void menuDisplay()
    {
        System.out.println("════════════════════════════");
        System.out.println("請選擇想要進行的動作：");
        System.out.println("[0] 離開系統");
        System.out.println("[1] 計算IV值");
        System.out.println("[2] 計算特定等級之CP值");
        System.out.println("[3] 計算目標CP值之最低等級");
        System.out.println("[4] 重新輸入寶可夢數值");
        System.out.print(">>> ");
    }
    
    public static void main(String[] args)
    {
        System.out.println("歡迎使用寶可夢能力值計算系統");
        System.out.println("════════════════════════════\n");
        int atk = 0, def = 0, sta = 0; //給定一初始值0，讓編譯器開心
        String statsName[] = {"個體攻擊(ATK)", "個體防禦(DEF)", "個體體力(STA)"};
        atk = statsInput(atk, statsName[0]);
        def = statsInput(def, statsName[1]);
        sta = statsInput(sta, statsName[2]);
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
                    int level = PokemonStats.readPokeLevel();
                    int cp = PokemonStats.calcCP(atk, def, sta, level);
                    System.out.println("CP值為：" + cp);
                    break;
                case 3:
                    int targetCP = PokemonStats.readCP();
                    int reachLevel = PokemonStats.calcTargetCPLevel(atk, def, sta, targetCP);
                    if(reachLevel == -1)
                    {
                        System.out.println("超過等級上限，無法達到此CP值！");
                    }
                    else
                    {
                        System.out.println("欲達到此CP值的最低等級為：【" + reachLevel + "】等");
                    }
                    break;
                case 4:
                    System.out.println("════════════════════════════");
                    atk = statsInput(atk, statsName[0]);
                    def = statsInput(def, statsName[1]);
                    sta = statsInput(sta, statsName[2]);
                    break;
                default:
                    System.out.println("發生錯誤，結束程式…");
                    System.exit(0);
            }
        }
    }
}
