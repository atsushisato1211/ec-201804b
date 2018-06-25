	
	DROP TABLE IF EXISTS items;
	create table items (
	  id bigserial not null
	  , name text not null unique
	  , description text not null
	  , producingArea text not null
	  , season text not null
	  , price integer not null
	  , imagePath text not null
	  , deleted boolean default false not null
	  , constraint items_PKC primary key (id)
	) ;

<<<<<<< HEAD
	INSERT INTO items  values(1,'きゅーり','宮崎県産',100,'001.jpg',true);
	INSERT INTO items  values(2,'きゃべつ','愛知県産',150,'002.jpg',true);
	INSERT INTO items  values(3,'枝豆','千葉県産',100,'003.jpg',true);
	INSERT INTO items  values(4,'にんじん','あいこう',100,'004.jpg',true);
	INSERT INTO items  values(5,'とうもろこし','分類：イネ科トウモロコシ属
	原産地：メキシコからグアテマラ、ボリビアなど南アメリカ北部
	季節の分類：夏
	多く出回る時期：6月～9月頃',100,'005.jpg',true);
	INSERT INTO items  values(6,'トマト','分類：ナス科トマト属
	原産地：南米アンデス高地
	季節の分類：夏',100,'006.jpg',true);
	INSERT INTO items  values(7,'うど','分類：ウコギ科タラノキ属
	原産地：日本
	季節の分類：春',200,'007.jpg',true);
	INSERT INTO items  values(8,'うり','分類：ウリ科キュウリ属（白うり）
	原産地：中国、インド（白うり）
	季節の分類：夏',250,'008.jpg',true);

	inSERT INTO items  values(9,'ごぼう','分類：キク科ゴボウ属
	原産地：ユーラシア大陸北部
	季節の分類：秋冬',75,'009.jpg',true);
	inSERT INTO items  values(10,'さつまいも','分類：ヒルガオ科サツマイモ属
	原産地：中米～南米北部
	季節の分類：秋',125,'010.jpg',true);
	inSERT INTO items  values(11,'じゃがいも','分類：ナス科ナス属
	原産地：南米アンデス高地
	季節の分類：春秋',30,'011.jpg',true);
	inSERT INTO items  values(12,'しょうが','分類：ショウガ科ショウガ属
	原産地：熱帯アジア
	季節の分類：夏',90,'012.jpg',true);

	inSERT INTO items  values(13,'たけのこ','分類：イネ科マダケ属
	原産地：中国（孟宗竹）
	季節の分類：春',90,'013.jpg',true);

	inSERT INTO items  values(14,'とうがらし','分類：ナス科トウガラシ属
	原産地：中南米の熱帯地方
	季節の分類：夏',50,'014.jpg',true);
	inSERT INTO items  values(15,'にんにく','分類：ネギ科ネギ属
	原産地：中央アジア
	季節の分類：春夏
	多く出回る時期：周年',110,'015.jpg',true);

	inSERT INTO items  values(16,'ほうれん草','分類：ヒユ科ホウレンソウ属
	原産地：西南アジア地域
	季節の分類：冬',120,'016.jpg',true);
	inSERT INTO items  values(17,'みずな','分類：アブラナ科アブラナ属
	原産地：日本
	季節の分類：冬春',90,'017.jpg',true);

	inSERT INTO items  values(18,'みつば','分類：セリ科ミツバ属
	原産地：東アジア
	季節の分類：冬春',40,'018.jpg',true);


	inSERT INTO items  values(19,'しょーが','分類：ショウガ科ハナミョウガ属
	原産地：アジア東部
	季節の分類：夏',50,'019.jpg',true);
	inSERT INTO items  values(20,'やまのいも','分類：ヤマノイモ科ヤマノイモ属
	原産地：中国（長いも、いちょういも、つくねいも）、日本（自然薯）
	季節の分類：夏秋',130,'020.jpg',true);
	inSERT INTO items  values(21,'れんこん','分類：ハス科ハス属
	原産地：中国、インド、エジプなど諸説あり
	季節の分類：秋冬',75,'021.jpg',true);