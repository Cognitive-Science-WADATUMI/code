import java.util.Scanner;

class SubMarine{
  static Scanner sc = new Scanner(System.in);
  //static int[][] us = new int[7][7];//0or1
  //static int[][] searchUs = new int[7][7];
  //static int[][] enemy = new int[7][7];
  static double[][] us = new double[7][7];//0or1
  static double[][] searchUs = new double[7][7];
  static double[][] enemy = new double[7][7];
  static int ourLife = 12;
  static int ourNum = 4;
  static int enemyLife = 12;
  static int enemyNum = 4;
  static int enemyAction = 0;//0...move , 1...attack
  static int countTurn = 0;
  static int nextRunAway = 0;//0 or 1
  static int sakkiAtatta = 0;
  static int sakkiAteta = 0;
  static int sakkiAtetaX = 0;
  static int sakkiAtetaY = 0;
  static int idousita = 0;

  static SMInf sub1;
  static SMInf sub2;
  static SMInf sub3;
  static SMInf sub4;

  //System.out
  public static void putNum(int n){
    System.out.print(n);
  }
  public static void putDouble(double d){
    System.out.print(d);
  }
  public static void putStr(String s){
    System.out.print(s);
  }
  public static void newline(){
    putStr("\n");
  }
  public static void putSub(SMInf sub){
    System.out.print(sub);
  }

  //set board
  public static void makeBoard(){
    fill(us); fill(enemy); fill(searchUs);
  }
  public static void fill(double[][] d){
    for(int i = 0; i < 7; i++){
      for(int j = 0; j < 7; j++){
        if(i == 0 || j == 0 || i == 6 || j == 6){
          d[i][j] = -1.0;
        }
        else{
          d[i][j] = 0.04;
        }
      }
    }
  }

  public static void setOurPosition(SMInf sub){
    int x = sub.getX();
    int y = sub.getY();
    us[x][y] = 1.0;
    return ;
  }

  public static void main(String[] args){
  //  Scanner sc = new Scanner(System.in);
    sub1 = new SMInf("sub1", 3, 1, 1);
    sub2 = new SMInf("sub2", 3, 2, 2);
    sub3 = new SMInf("sub3", 3, 3, 3);
    sub4 = new SMInf("sub4", 3, 4, 4);
    makeBoard();


    setOurPosition(sub1);
    setOurPosition(sub2);
    setOurPosition(sub3);
    setOurPosition(sub4);

    putStr("which goes first?  us = 0 , enemy = 1:  ");
    int first = sc.nextInt();
    if(first == 0){
      putStr("we go first.\n");
      ourTurn();
      countTurn++;
      showSituation();
    }

    int con;//continue or not
    do{
      enemysTurn();
      countTurn++;
      showSituation();
      putStr("continue? yes(1) or no(0): ");
      con = sc.nextInt();
      if(con == 0){
        break;
      }

      ourTurn();
      countTurn++;
      showSituation();
      putStr("continue? yes(1) or no(0): ");
      con = sc.nextInt();
      if(con == 0){
        break;
      }

    }while(ourNum > 0 && enemyNum > 0);
  }

  public static void enemysTurn(){
    putStr("Enemy's turn.\n");
    putStr("move(0) or attack(1): ");
    enemyAction = sc.nextInt();//0 move, 1 ttack
    if(enemyAction == 0){//move
      idousita = 1;
      putStr("direction  east(1), west(2), south(3), north(4): ");
      int dir = sc.nextInt();
      putStr("num 1 or 2: ");
      int dirnum = sc.nextInt();
      if(dir == 1){//east
        for(int i = 0; i < 7; i++){
          for(int j = dirnum; j < 7; j++){
            if(enemy[i][j] != -1.0){
              enemy[i][j] += 0.05;
            }
            putDouble(enemy[i][j]);
            putStr("   ");
          }
          putStr("\n");
        }
      }//east
      if(dir == 2){//west
        for(int i = 0; i < 7; i++){
          for(int j = 0; j < 7 - dirnum - 1; j++){
            if(enemy[i][j] != -1.0){
              enemy[i][j] += 0.05;
            }
            putDouble(enemy[i][j]);
            putStr("   ");
          }
          putStr("\n");
        }
      }//west
      if(dir == 3){//south
        for(int i = dirnum; i < 7; i++){
          for(int j = 0; j < 7; j++){
            if(enemy[i][j] != -1.0){
              enemy[i][j] += 0.05;
            }
            putDouble(enemy[i][j]);
            putStr("   ");
          }
          putStr("\n");
        }
      }//south
      if(dir == 4){//north
        for(int i = 0; i < 7 - dirnum - 1; i++){
          for(int j = 0; j < 7; j++){
            if(enemy[i][j] != -1.0){
              enemy[i][j] += 0.05;
            }
            putDouble(enemy[i][j]);
            putStr("   ");
          }
          putStr("\n");
        }
      }//north
      return;
    }
    else if(enemyAction == 1){//attack
      int x, y;
      putStr("x: "); x = sc.nextInt();
      putStr("y: "); y = sc.nextInt();
      enemy[x][y] = 0.0;
      for(int i = x-1; i < x+2; i++){
        for(int j = y-1; j < y+2; j++){
          if(enemy[i][j] != -1 && enemy[i][j] != 1){
              enemy[i][j] += 0.125;
          }
        }
      }

      if(us[x][y] == 1.0){//hit
        sakkiAtatta = 1;
        ourLife--;
        int sub1x = sub1.getX(), sub1y = sub1.getY();
        if(x == sub1x && y == sub1y){
          sub1.declimentHP();
          int sub1hp = sub1.getHP();
          if(sub1hp == 0){
            ourNum--;
            putStr("sub1 sunk!!\n");
            us[x][y] = -1.0;
            enemy[x][y] = -1.0;
            searchUs[x][y] = -1.0;
            return;
          }
          putStr("hit!\n");
          return;
        }
        int sub2x = sub2.getX(), sub2y = sub2.getY();
        if(x == sub2x && y == sub2y){
          sub2.declimentHP();
          int sub2hp = sub2.getHP();
          if(sub2hp == 0){
            ourNum--;
            putStr("sub2 sunk!!\n");
            us[x][y] = -1.0;
            enemy[x][y] = -1.0;
            searchUs[x][y] = -1.0;
            return;
          }
          putStr("hit!\n");
          return;
        }
        int sub3x = sub3.getX(), sub3y = sub3.getY();
        if(x == sub3x && y == sub3y){
          sub3.declimentHP();
          int sub3hp = sub3.getHP();
          if(sub3hp == 0){
            ourNum--;
            putStr("sub3 sunk!!\n");
            us[x][y] = -1.0;
            enemy[x][y] = -1.0;
            searchUs[x][y] = -1.0;
            return;
          }
          putStr("hit!\n");
          return;
        }
        int sub4x = sub4.getX(), sub4y = sub4.getY();
        if(x == sub4x && y == sub4y){
          sub4.declimentHP();
          int sub4hp = sub4.getHP();
          if(sub4hp == 0){
            ourNum--;
            putStr("sub4 sunk!!\n");
            us[x][y] = -1.0;
            enemy[x][y] = -1.0;
            searchUs[x][y] = -1.0;
            return;
          }
          putStr("hit!\n");
          return;
        }
      }
      for(int i = x - 1; i < x + 2; i++){//namitakasi
        for(int j = y - 1; j < y + 2; j++){
          if(us[i][j] == 1.0){
            putStr("nami takasi!\n");
            return;
          }
        }
      }
      putStr("hazure\n");//hazure
      return;
    }
  }

  public static void ourTurn(){
    putStr("Our turn.\n"); newline();
    int x, y;
    x = 1;
    y = 1;
    putStr("attack "); putNum(x); putStr("-"); putNum(y); newline();
    putStr("sunk(0), hit(1), namitakasi(2), hazure(3): ");
    int result = sc.nextInt();
    if(result == 0){//sunk
      enemyNum--;
      enemyLife--;
      us[x][y] = -1.0;
      enemy[x][y] = -1.0;
      searchUs[x][y] = -1.0;
      sakkiAteta = 0;
      return;
    }
    if(result == 1){//hit
      enemyLife--;
      enemy[x][y] = 1.0;
      sakkiAteta = 1;
      sakkiAtetaX = x;
      sakkiAtetaY = y;
      return;
    }
    if(result == 2){//namitakasi
      for(int i = x-1; i < x+2; i++){
        for(int j = y-1; j < y+2; j++){
          if(enemy[x][y] != 0 && enemy[x][y] != 1){
            enemy[x][y] += 0.125;
          }
        }
      }
      enemy[x][y] = 0;
      sakkiAteta = 0;
      return;
    }
    if(result == 3){//hazure
      for(int i = x-1; i < x+2; i++){
        for(int j = y-1; j < y+2; j++){
          if(enemy[i][j] != -1.0){
            enemy[i][j] = 0.0;
          }
        }
      }
      sakkiAteta = 0;
      return;
    }
  }

  public static void showSituation(){
    newline();
    putStr("turn"); putNum(countTurn); newline();
    putSub(sub1); putSub(sub2); putSub(sub3); putSub(sub4);
    //newline();
    putStr("ourNum: "); putNum(ourNum); putStr("  ourHP: "); putNum(ourLife); newline();
    putStr("enemyNum: "); putNum(enemyNum); putStr("  enemy'sHP: "); putNum(enemyLife); newline();
    newline();
  }

}