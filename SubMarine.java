import java.util.Scanner;

class SubMarine{
  static double[][] sub = new int[7][7];//0 or 1 自陣管理
  static double[][] ob = new double[7][7];//敵目線自陣
  static double[][] enemy = new double[7][7];//索敵
  static int ourNum = 4;//自陣残機
  static int enemyLife = 12;//敵総HP
  static int enemyNum = 4;//敵残機
  static String enemyAction;//攻撃か移動かを受け取る文字列

  public void makeBoard(){//盤面初期化
    fill(sub); fill(enemy); fill(searchUs);
  }
  public void fill(double[][] d){//初期化の中身
    for(int i = 0; i < d.length(); i++){
      for(int j = 0; j < d[i].length(); j++){
        if(i == 0 || j == 0 || i == d.length()-1 || j == d[i].length()-1){
          final d[i][j] = -1;
        }
        else{
          d[i][j] = 0;
        }
      }
    }
  }

  public static void main(String[] args){
    Scanner sc = new Scanner();
    SMInf sub1 = new SMInf("sub1", 3, 1, 1);
    SMInf sub2 = new SMInf("sub2", 3, 2, 2);
    SMInf sub3 = new SMInf("sub3", 3, 3, 3);
    SMInf sub4 = new SMInf("sub4", 3, 4, 4);
    
    makeBoard();

    //ここまで事前処理
    
    Scanner sc = new Scanner(System.in);

    while(ourNum > 0 && enemyLife > 0){//loop
      enemyAction();
      ourAction();

      if(enemyLife <= 0){//end 1
        put("We Win!!!\n");
        return;
      }
      if(ourNum <= 0){//end 2
        put("We lose.\n");
        return ;
      }
    }


  }
  public String weMove(int x, int y, String s){//座標と艦の名前

  }

  public void enemyAction(){

    put("enemy's action: ")
    string es = sc.nextString();//敵行動(attack or move)を入力
    if(es = "move"){
      String eDirection = sc.nextString();
      int moveNum = sc.nextInt();

      enemyMove(eDirection, moveNum);

    }
    if(es = "attack"){
      int ex = -1;
      do{
        put("fill x and y.\n");
        char ea = sc.nextChar();
        int ey = sc.nextInt();
        ex = transCtoI(ea);
      }while(ea > 0;)

      response(ex, ey);
    }

  }

  public void response(int x. int y){
    String result = judge(x, y);  //行動入力
    //周辺マスの値の変更
    
  }
  public String judge(int x, int y){
    //判定プログラム(命中か波高しかはずれ)
    String result;
    
    
    return result;
  }

  public int transCtoI(char ch){
    if(ch == 'a'){return 1;}
    if(ch == 'b'){return 2;}
    if(ch == 'c'){return 3;}
    if(ch == 'd'){return 4;}
    if(ch == 'e'){return 5;}
    else return -1;
  }
  public void put(String s){
    System.out.print(s);
  }

  public void enemyMove(String sdir, int num){
    if(sdir == "north"){
      for(int i = 1; i < 6 - num; i++){
        for(int j = 1; j < 6; j++){
          enemy[i][j] += 0.125;
        }
      }
    }
    else if(sdir == "south"){
      for(int i = 1 + num; i < 6; i++){
        for(int j = 1; j < 6; j++){
          enemy[i][j] += 0.125;
        }
      }
    }
    else if(sdir == "east"){
      for(int i = 1; i < 6; i++){
        for(int j = 1 + num; j < 6; j++){
          enemy[i][j] += 0.125;
        }
      }
    }
    else if(sdir == "west"){
      for(int i = 1; i < 6; i++){
        for(int j = 1; j < 6 - num; j++){
          enemy[i][j] += 0.125;
        }
      }
    }
  }



}
