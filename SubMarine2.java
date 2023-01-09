import java.util.Scanner;

class SubMarine2{
  static Scanner sc = new Scanner(System.in);
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
  static int sakkinoidoukyori = 0;
  static int MorA = 1;//0 move   1 attack

  static SMInf sub1;
  static SMInf sub2;
  static SMInf sub3;
  static SMInf sub4;

  static double[][] sub1attack = new double[8][3];
  static double[][] sub1move = new double[8][3];
  static double[][] sub2attack = new double[8][3];
  static double[][] sub2move = new double[8][3];
  static double[][] sub3attack = new double[8][3];
  static double[][] sub3move = new double[8][3];
  static double[][] sub4attack = new double[8][3];
  static double[][] sub4move = new double[8][3];

  //System.out
  public static void putNum(int n){
    System.out.print(n);
  }
  public static void putDouble(double d){
    System.out.print(d);
  }
  public static void putChar(char c){
    System.out.print(c);
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
  public static void setAttackAndMove(){
    int sub1x = sub1.getX(), sub1y = sub1.getY(),
        sub2x = sub2.getX(), sub2y = sub2.getY(),
        sub3x = sub3.getX(), sub3y = sub3.getY(),
        sub4x = sub4.getX(), sub4y = sub4.getY();

    fillattack(sub1attack, sub1x, sub1y);
    fillattack(sub2attack, sub2x, sub2y);
    fillattack(sub3attack, sub3x, sub3y);
    fillattack(sub4attack, sub4x, sub4y);

    fillMove(sub1move, sub1x, sub1y);
    fillMove(sub2move, sub2x, sub2y);
    fillMove(sub3move, sub3x, sub3y);
    fillMove(sub4move, sub4x, sub4y);

  }
  public static void fillMove(double[][] d, int x, int y){
    for(int i = 0; i < 8; i++){
      for(int j = 0; j < 3; j++){
        if(j == 0){//x
          if(i == 0){
            if(x-2 < 0){
              d[i][j] = -1;
            }
            else{
              d[i][j] = x-2;
            }
          }
          if(i == 1){
            d[i][j] = x-1;
          }
          if(i == 2 || i == 3 || i == 6 || i == 7){
            d[i][j] = x;
          }
          if(i == 4){
            if(x+2 > 6){
              d[i][j] = -1;
            }
            else{
              d[i][j] = x+2;
            }
          }
          if(i == 5){
            d[i][j] = x+1;
          }
        }
        if(j == 1){//y
          if(i == 0 || i == 1 || i == 4 || i == 5){
            d[i][j] = y;
          }
          if(i == 2){
            if(y+2 > 6){
              d[i][j] = -1;
            }
            else{
              d[i][j] = y+2;
            }
          }
          if(i == 3){
            d[i][j] = y+1;
          }
          if(i == 6){
            if(y-2 < 0){
              d[i][j] = -1;
            }
            else{
              d[i][j] = y-2;
            }
          }
          if(i == 7){
            d[i][j] = y-1;
          }
        }
        if(j == 2){//searchUs
          if((d[i][j-2] != -1) && (d[i][j-1] != -1)){
            d[i][j] = searchUs[(int)d[i][j-2]][(int)d[i][j-1]];
          }
          else{
            d[i][j] = -1;
          }
        }
      }
    }
  }

  public static void fillattack(double[][] d, int x, int y){
    for(int i = 0; i < 8; i++){
      for(int j = 0; j < 3; j++){
        if(j == 0){
          if(i == 0 || i == 3 || i == 5){
            d[i][j] = x-1;
          }
          else if(i == 1 || i == 6){
            d[i][j] = x;
          }
          else{
            d[i][j] = x + 1;
          }
        }
        if(j == 1){
          if(i < 3){
            d[i][j] = y-1;
          }
          else if(i < 5){
            d[i][j] = y;
          }
          else{
            d[i][j] = y+1;
          }
        }
        if(j == 2){
          d[i][j] = enemy[(int)d[i][j-2]][(int)d[i][j-1]];
        }
      }
    }
    return;
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

    setAttackAndMove();
    putDouble(sub1attack[3][1]); newline();

    int con;//continue or not no switch

    putStr("which goes first?  us = 0 , enemy = 1:  ");
    int first = sc.nextInt();
    if(first == 0){//syote wareware
      ourTurn();
      countTurn++;
      showSituation();
      putStr("continue? yes(1) or no(0): ");
      con = sc.nextInt();
      if(con == 0){
        return;
      }
    }

    do{
      enemysTurn();
      countTurn++;
      showSituation();
      putStr("continue? yes(1) or no(0): ");
      con = sc.nextInt();
      if(con == 0){
        break;
      }

      if(ourNum < 0 || enemyNum < 0){ break;}

      ourTurn();
      countTurn++;
      showSituation();
      putStr("continue? yes(1) or no(0): ");
      con = sc.nextInt();
      if(con == 0){
        break;
      }

    }while(ourNum > 0 && enemyNum > 0);
    gameResult();//kekka
    return;//owari
  }

  public static void gameResult(){
    putStr("******** game result ********\n");
    if(ourNum > enemyNum){
      putStr("we win!!!!\n");
      return;
    }
    if(ourNum < enemyNum){
      putStr("we lose...\n");
      return;
    }
    if(ourLife > enemyLife){
      putStr("we win!!!\n");
      return;
    }
    if(ourLife < enemyLife){
      putStr("we lose...\n");
      return;
    }
    putStr("draw\n");
    return;
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
    putStr("Our turn.\n");

    if(MorA == 1){ weAttack();}
    if(MorA == 0){ weMove();}
  }
  public static void weAttack(){
    int[] kougekisaki = new int[2];
    kougekisaki = decideAttackPlace();
    int x = 0, y = 0;
    x = kougekisaki[0]; y = kougekisaki[1];

    char xc = ItoC(x);
    putStr("attack "); putChar(xc); putStr("-"); putNum(y); newline();
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
  public static void weMove(){
    int movenum = 0, movex = 0, movey = 0;
  }
    public static int[] decideAttackPlace(){
    int[] a = new int[2];
    double d = -0.5;
    Random rnd = new Random();
    int r;
    r = (int)Math.round(rnd.nextDouble());

    for(int i = 0; i < 8; i++){//sub1 hanntei
      if(d < sub1attack[i][2]){
        d = sub1attack[i][2];
        a[0] = (int)sub1attack[i][0];
        a[1] = (int)sub1attack[i][1];
        System.out.println(a[0] + " " + a[1] + "   " + d);
      }
      else if(d == sub1attack[i][2]){
        r = (int)Math.round(rnd.nextDouble());
        if(r == 1){
          d = sub1attack[i][2];
          a[0] = (int)sub1attack[i][0];
          a[1] = (int)sub1attack[i][1];
          System.out.println(a[0] + " " + a[1] + "   " + d);

        }
      }
    }
    for(int i = 0; i < 8; i++){//sub2 hanntei
      if(d < sub2attack[i][2]){
        d = sub2attack[i][2];
        a[0] = (int)sub2attack[i][0];
        a[1] = (int)sub2attack[i][1];
        System.out.println(a[0] + " " + a[1] + "   " + d);

      }
      else if(d == sub2attack[i][2]){
        r = (int)Math.round(rnd.nextDouble());
        if(r == 1){
          d = sub2attack[i][2];
          a[0] = (int)sub2attack[i][0];
          a[1] = (int)sub2attack[i][1];
          System.out.println(a[0] + " " + a[1] + "   " + d);
        }
      }
    }
    for(int i = 0; i < 8; i++){//sub3 hanntei
      if(d < sub3attack[i][2]){
        d = sub3attack[i][2];
        a[0] = (int)sub3attack[i][0];
        a[1] = (int)sub3attack[i][1];
        System.out.println(a[0] + " " + a[1] + "   " + d);

      }
      else if(d == sub3attack[i][2]){
        r = (int)Math.round(rnd.nextDouble());
        if(r == 1){
          d = sub3attack[i][2];
          a[0] = (int)sub3attack[i][0];
          a[1] = (int)sub3attack[i][1];
          System.out.println(a[0] + " " + a[1] + "   " + d);

        }
      }
    }
    for(int i = 0; i < 8; i++){//sub4 hanntei
      if(d < sub4attack[i][2]){
        d = sub4attack[i][2];
        a[0] = (int)sub4attack[i][0];
        a[1] = (int)sub4attack[i][1];
        System.out.println(a[0] + " " + a[1] + "   " + d);

      }
      else if(d == sub4attack[i][2]){
        r = (int)Math.round(rnd.nextDouble());
        if(r == 1){
          d = sub4attack[i][2];
          a[0] = (int)sub4attack[i][0];
          a[1] = (int)sub4attack[i][1];
          System.out.println(a[0] + " " + a[1] + "   " + d);

        }
      }
    }

    return a;
  }
  public static void changeMorA(){
    MorA--;
    MorA *= MorA;
    putNum(MorA); newline();
  }

  public static char ItoC(int n){
    char c = 'z';
    if(n == 1){ c = 'a';}
    else if(n == 2){ c = 'b';}
    else if(n == 3){ c = 'c';}
    else if(n == 4){ c = 'd';}
    else if(n == 5){ c = 'e';}
    return c;
  }

  public static void showSituation(){
    newline();
    putStr("turn"); putNum(countTurn); newline();
    putSub(sub1); putSub(sub2); putSub(sub3); putSub(sub4);
    putNum(MorA); newline();
    putStr("ourNum: "); putNum(ourNum); putStr("  ourHP: "); putNum(ourLife); newline();
    putStr("enemyNum: "); putNum(enemyNum); putStr("  enemy'sHP: "); putNum(enemyLife); newline();
    putStr("**********************************\n");
  }

}
