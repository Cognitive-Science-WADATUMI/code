class MoveOrAttack{
  //attack
    //波高しかつHP3
  if( result == 'namitakashi' && (putSub(sub1)==3 || putSub(sub2)==3 || putSub(sub3)==3 )){
    
  }
  
  //命中かつ次ターン以降攻撃の場合(move→attack)
  if( result == 'hit' && (putSub(sub1)==1 || putSub(sub2)==1 || putSub(sub3)==1 )){
    
  }
  

  //move
    //波高しでHP2の場合
  if( result == 'namitakashi' && (putSub(sub1)==2 || putSub(sub2)==2 || putSub(sub3)==2 )){
    
  }
    //命中かつHP1の場合
  if( result == 'hit' && (putSub(sub1)==1 || putSub(sub2)==1 || putSub(sub3)==1 )){
    
  }
    //命中かつHP2の場合
  if( result == 'hit' && (putSub(sub1)==2 || putSub(sub2)==2 || putSub(sub3)==2 )){
    
  }
  /* どうすればよいのか分からず全く手が付けられない。今勉強してます、sorry..... */

