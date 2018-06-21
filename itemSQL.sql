	
	DROP TABLE IF EXISTS items;
	create table items (
	  id bigserial not null
	  , name text not null unique
	  , description text not null
	  , price integer not null
	  , imagePath text not null
	  , deleted boolean default false not null
	  , constraint items_PKC primary key (id)
	) ;

	INSERT INTO items  values(1,'����[��','�{�茧�Y',100,'001.jpg',true);
	INSERT INTO items  values(2,'����ׂ�','���m���Y',150,'002.jpg',true);
	INSERT INTO items  values(3,'�}��','��t���Y',100,'003.jpg',true);
	INSERT INTO items  values(4,'�ɂ񂶂�','��������',100,'004.jpg',true);
	INSERT INTO items  values(5,'�Ƃ����낱��','���ށF�C�l�ȃg�E�����R�V��
	���Y�n�F���L�V�R����O�A�e�}���A�{���r�A�ȂǓ�A�����J�k��
	�G�߂̕��ށF��
	�����o��鎞���F6���`9����',100,'005.jpg',true);
	INSERT INTO items  values(6,'�g�}�g','���ށF�i�X�ȃg�}�g��
	���Y�n�F��ăA���f�X���n
	�G�߂̕��ށF��',100,'006.jpg',true);
	INSERT INTO items  values(7,'����','���ށF�E�R�M�ȃ^���m�L��
	���Y�n�F���{
	�G�߂̕��ށF�t',200,'007.jpg',true);
	INSERT INTO items  values(8,'����','���ށF�E���ȃL���E�����i������j
	���Y�n�F�����A�C���h�i������j
	�G�߂̕��ށF��',250,'008.jpg',true);

	inSERT INTO items  values(9,'���ڂ�','���ށF�L�N�ȃS�{�E��
	���Y�n�F���[���V�A�嗤�k��
	�G�߂̕��ށF�H�~',75,'009.jpg',true);
	inSERT INTO items  values(10,'���܂���','���ށF�q���K�I�ȃT�c�}�C����
	���Y�n�F���ā`��Ėk��
	�G�߂̕��ށF�H',125,'010.jpg',true);
	inSERT INTO items  values(11,'���Ⴊ����','���ށF�i�X�ȃi�X��
	���Y�n�F��ăA���f�X���n
	�G�߂̕��ށF�t�H',30,'011.jpg',true);
	inSERT INTO items  values(12,'���傤��','���ށF�V���E�K�ȃV���E�K��
	���Y�n�F�M�уA�W�A
	�G�߂̕��ށF��',90,'012.jpg',true);

	inSERT INTO items  values(13,'�����̂�','���ށF�C�l�ȃ}�_�P��
	���Y�n�F�����i�Џ@�|�j
	�G�߂̕��ށF�t',90,'013.jpg',true);

	inSERT INTO items  values(14,'�Ƃ����炵','���ށF�i�X�ȃg�E�K���V��
	���Y�n�F����Ă̔M�ђn��
	�G�߂̕��ށF��',50,'014.jpg',true);
	inSERT INTO items  values(15,'�ɂ�ɂ�','���ށF�l�M�ȃl�M��
	���Y�n�F�����A�W�A
	�G�߂̕��ށF�t��
	�����o��鎞���F���N',110,'015.jpg',true);

	inSERT INTO items  values(16,'�ق����','���ށF�q���ȃz�E�����\�E��
	���Y�n�F����A�W�A�n��
	�G�߂̕��ށF�~',120,'016.jpg',true);
	inSERT INTO items  values(17,'�݂���','���ށF�A�u���i�ȃA�u���i��
	���Y�n�F���{
	�G�߂̕��ށF�~�t',90,'017.jpg',true);

	inSERT INTO items  values(18,'�݂�','���ށF�Z���ȃ~�c�o��
	���Y�n�F���A�W�A
	�G�߂̕��ށF�~�t',40,'018.jpg',true);


	inSERT INTO items  values(19,'����[��','���ށF�V���E�K�ȃn�i�~���E�K��
	���Y�n�F�A�W�A����
	�G�߂̕��ށF��',50,'019.jpg',true);
	inSERT INTO items  values(20,'��܂̂���','���ށF���}�m�C���ȃ��}�m�C����
	���Y�n�F�����i�������A�����傤�����A���˂����j�A���{�i���R���j
	�G�߂̕��ށF�ďH',130,'020.jpg',true);
	inSERT INTO items  values(21,'��񂱂�','���ށF�n�X�ȃn�X��
	���Y�n�F�����A�C���h�A�G�W�v�ȂǏ�������
	�G�߂̕��ށF�H�~',75,'021.jpg',true);