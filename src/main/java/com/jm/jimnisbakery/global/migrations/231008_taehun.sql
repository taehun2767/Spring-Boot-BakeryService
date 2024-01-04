// 필드 변경
alter table comments change column description content varchar(300) not null;
alter table breads change column view_order review_rating float null;