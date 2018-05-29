# 2018.05.08
# my.conf 에 utf-8 설정을 추가 할 것

#2018.05.10
#부적합한 속성명 변경 use -> used, function -> functionFor

#2018.05.29
#테이블 속성 변경 및 추가 

drop database if exists chemdb;
create database chemdb;
use chemdb;


#질의응답 테이블
drop table if exists inquiry;
CREATE TABLE `chemdb`.`inquiry` (
    `num` INT NOT NULL auto_increment,
    `email` VARCHAR(100) NULL,
    `title` VARCHAR(200) NULL,
    `content` VARCHAR(500) NULL,
	`inquiryType` varchar(10) Null,
    PRIMARY KEY (`num`)
)  DEFAULT CHARSET=UTF8;

 
#화학성분 테이블
drop table if exists cheminfo;
CREATE TABLE `cheminfo` (
    `nameK` VARCHAR(100)  NOT NULL,		#성분명
    `nameE` VARCHAR(150) NULL,			#영문명
    `cas` VARCHAR(200) NULL,			#casNo.
    `definition` VARCHAR(300) NULL,		#정의 및 기원
    `used` VARCHAR(500) NULL,			#용도
    `dryGood` VARCHAR(50) NULL,			#건성에 좋은
    `dryBad` VARCHAR(50) NULL,			#건성에 나쁜
    `oilGood` VARCHAR(50) NULL,			#지성에 좋은
    `oilBad` VARCHAR(50) NULL,			#지성에 나쁜
    `sensitiveGood` VARCHAR(50) NULL,	#민감성에 좋은
    `sensitiveBad` VARCHAR(50) NULL,	#민감성에 나쁜
    `complexBad` VARCHAR(50) NULL,		#복합성에 나쁜
    `functionFor` VARCHAR(300) NULL,	#기능성(미백,주름완화,자외선차단)
    `allergy` VARCHAR(200) NULL,		#아토피(알레르기)
    `warning` VARCHAR(500) NULL,		#사용시 제한
    `acne` VARCHAR(100) NULL,			#여드름에 나쁜
    `baby` VARCHAR(50) NULL,			#유아 사용금지
    `productList` VARCHAR(100) NULL,	#제품 항목별 함유
    PRIMARY KEY (`nameK`)
)  DEFAULT CHARSET=UTF8;
  
# 제품명 테이블
drop table if exists product;
CREATE TABLE `product` (
    productname VARCHAR(300) NOT NULL,
    productnameK VARCHAR(300) NOT NULL,
    productingredient VARCHAR(600) NOT NULL,
    PRIMARY KEY (`productname`)
)  DEFAULT CHARSET=UTF8;

#화학성분 데이터 
INSERT INTO `chemdb`.`cheminfo` (`nameK`, `nameE`, `cas`, `definition`, `used`, `dryGood`, `dryBad`, `oilGood`, `oilBad`, `sensitiveGood`, `sensitiveBad`, `complexBad`, `functionFor`, `allergy`, `warning`, `acne`, `baby`, `productList`) VALUES ('﻿드로메트리졸트리실록산', 'Drometrizole Trisiloxane', '155633-54-8', '이 원료는 헤테로고리 화합물이다.', '피부컨디셔닝제(기타) : 건조하거나 손상된 피부를 개선, 피부탈락 감소, 유연성 회복 등 피부에 특별한 효과를 주기 위한 성분', '보습력 증가', '피부 자극', '피지 조절', '모공 막힘', '윤기 증가', '피부 자극', '피부자극', '기능성화장품 심사에 관한 규정 : 자외선으로부터 피부를 보호하는데 도움을 주는 기능성 화장품', '일본 NITE 분류-알레르기 피부 반응을 일으킬 수 있는 성분/식약처 고시-알레르기 유발 가능성이 있는 성분', '화장품 안전기준 등에 관한 규정 : 사용상의 제한이 필요한 원료(자외선차단제)/15%까지 함유 허용', '피부에 자극을 일으킬 수 있는 성분(일본 NITE 분류)/피부에 자극을 줄 수 있는 성분(미국 IRIS 평가)', '3세 이하 어린이 사용금지', '마스크팩/헤어팩/에센스/립밤/오일');
INSERT INTO `chemdb`.`cheminfo` (`nameK`, `nameE`, `cas`, `definition`, `used`, `dryGood`, `dryBad`, `oilGood`, `oilBad`, `sensitiveGood`, `sensitiveBad`, `complexBad`, `functionFor`, `allergy`, `warning`, `acne`, `baby`, `productList`) VALUES ('아이오도프로피닐부틸카바메이트', 'Iodopropynyl Butylcarbamate', '55406-53-6', '이 원료는 유기화합물이다.', '살균보존제 : 화장품중의 미생물의 증식을 억제하기 위하여 가하는 물질', '', '', '피지 조절 및 수렴/피부 진정', '', '', '', '', '', '일본 NITE 분류-알레르기 피부 반응을 일으킬 수 있는 성분', '화장품 안전기준 등에 관한 규정 : 사용상의 제한이 필요한 원료(살균보존제)/사용 후 씻어내는 제품에 0.02% 까지 함유 허용/사용 후 씻어내지 않는 제품에 0.01% 까지 함유 허용/데오드란트에 배합할 경우에는 0.0075% 까지 함유 허용/입술에 사용되는 제품, 에어로졸(스프레이에 한함) 제품, 바디로션 및 바디크림에는 사용금지', '', '3세 이하 어린이 사용금지', '수분크림/스킨/로션/틴트/립글로이드');
INSERT INTO `chemdb`.`cheminfo` (`nameK`, `nameE`, `cas`, `definition`, `used`, `dryGood`, `dryBad`, `oilGood`, `oilBad`, `sensitiveGood`, `sensitiveBad`, `complexBad`, `functionFor`, `allergy`, `warning`, `acne`, `baby`, `productList`) VALUES ('소듐폴리아크릴레이트', 'Sodium Polyacrylate', '9003-04-7_25549-84-2', '이 원료는 폴리아크릴릭애씨드의 소듐염이다.', '흡수제 : 물이나 기름에 녹아있거나 분산되어 있는 물질을 취하는데 사용되는 원료/유화안정제 : 유화 과정을 도와주고, 제형의 안정성 및 수명을 증진시키기 위하여 첨가하는 물질/피막형성제 : 피부, 머리카락 또는 손톱 등에 필름을 형성할 수 있도록 하기위해 사용/모발고정제 : 모발의 고정이나 모발모양에 특성을 부여하는 물질/피부유연화제 : 피부를 부드럽고 고르게 만들어주고 얇은 보습막을 씌워 수분이 날아가는 것을 억제해주는 성분/점도조절제 : 제품의 점도를 증가시키거나 감소시키기 위하여 첨가하는 물질/점도증가제(수성) : 제품의 점도를 증가시키기 위하여 첨가하는 물질', '보습력 증가', '피부 자극', '피지 조절', '모공 막힘', '윤기 증가', '피부 자극', '', '', '', '', '', '', '워시오프팩/메이크업베이스/헤어팩');
INSERT INTO `chemdb`.`cheminfo` (`nameK`, `nameE`, `cas`, `definition`, `used`, `dryGood`, `dryBad`, `oilGood`, `oilBad`, `sensitiveGood`, `sensitiveBad`, `complexBad`, `functionFor`, `allergy`, `warning`, `acne`, `baby`, `productList`) VALUES ('벤조페논-3', 'Benzophenone-3', '131-57-7', '이 원료는 벤조페논 유도체이다.', '산화방지제 : 산소에 의하여 증진되는 반응을 억제하여 산화와 부패를 방지하기 위한 성분/감미제 : 화장품의 맛을 증진시키는 성분. 주로 립스틱 류에 사용/변색방지제 : 자외선을 차단시켜 자외선에 의한 화학적, 물리적 변화로부터 완제품을 보호하기 위해 사용되는 성분', '피부 재생 세포 증가', '피부 자극', '피지 조절', '피부 자극', '피부 속 혈관 강화', '피부 자극', '피부 자극', '기능성화장품 심사에 관한 규정 : 자외선으로부터 피부를 보호하는데 도움을 주는 기능성 화장품', '일본 NITE 분류-알레르기 피부 반응을 일으킬 수 있는 성분', '화장품 안전기준 등에 관한 규정 : 사용상의 제한이 필요한 원료(자외선차단제)/5%까지 함유 허용', '피부에 자극을 일으킬 수 있는 성분(일본 NITE 분류)/피부에 자극을 줄 수 있는 성분(미국 IRIS 평가)', '', '수분크림/스킨/로션/틴트/립글로이드');
INSERT INTO `chemdb`.`cheminfo` (`nameK`, `nameE`, `cas`, `definition`, `used`, `dryGood`, `dryBad`, `oilGood`, `oilBad`, `sensitiveGood`, `sensitiveBad`, `complexBad`, `functionFor`, `allergy`, `warning`, `acne`, `baby`, `productList`) VALUES ('레티놀', 'Retinol', '68-26-8_11103-57-4', '이 원료는 유기화합물이다.', '피부컨디셔닝제(기타) : 건조하거나 손상된 피부를 개선, 피부탈락 감소, 유연성 회복 등 피부에 특별한 효과를 주기 위한 성분', '', '', '', '', '', '피부 자극', '', '기능성화장품 심사에 관한 규정 : 피부의 주름 완화에 도움을 주는 기능성 화장품(1%)', '', '', '', '영유아용 제품류에 사용할 수 없음', '수분크림/스킨/로션/틴트/립글로이드');

#제품명 데이터
INSERT INTO `chemdb`.`product` (`productname`, `productnameK`, `productingredient`) VALUES ('﻿THE BODY SHOP WHITE MUSK CREME POUR LES MAINS', '더바디샵 화이트 머스크 핸드 크림', '정제수_글리세린_세테아릴알코올_디메치콘_글리세릴스테아레이트');
INSERT INTO `chemdb`.`product` (`productname`, `productnameK`, `productingredient`) VALUES ('MIRACLE FINISH', '더페이스샵 안티다크닝 쿠션 SPF50+ PA+++', '정제수_메칠트리메치콘_티타늄디옥사이드_사이클로펜타실록산_디카프릴릴카보네이트_변성알코올_판테놀_소듐라우로일락틸레이트_데사미도콜라겐_마시멜로뿌리추출물_세라마이드엔피_피토스핑고신_캐모마일꽃추출물_알로에베라잎추출물_소나무잎추출물_레몬밤꽃/잎/줄기수_귤껍질추출물_감나무잎추출물_유칼립투스잎추출물_스테아릭애씨드_소듐클로라이드_팔미토일프롤린_소듐팔미토일사코시네이트_마그네슘팔미토일글루타메이트_아데노신_실리카_바이오사카라이드검-1_팔미틱애씨드_하이알루로닉애씨드_부틸렌글라이콜_에칠헥실글리세린_잔탄검');
INSERT INTO `chemdb`.`product` (`productname`, `productnameK`, `productingredient`) VALUES ('Perfect Whip', '센카 퍼펙트 휩 N', '정제수_스테아릭애씨드_미리스틱애씨드_글리세린_라우릭애씨드_에탄올_부틸렌글라이콜_디소듐이디티에이_소듐벤조에이트_소듐메타바이설파이트_소듐하이알루로네이트_세리신_시트릭애씨드');
INSERT INTO `chemdb`.`product` (`productname`, `productnameK`, `productingredient`) VALUES ('21c', '아이오페 에어쿠션', '정제수_사이클로펜타실록산_징크옥사이드_에칠헥실메톡시신나메이트_사이클로헥사실록산_티타늄디옥사이드_티타늄디옥사이드_나이아신아마이드_디메치콘_글라이신_글루타믹애씨드_디소듐이디티에이_락틱애씨드_레시틴_류신_리파아제_마그네슘글루코네이트_부틸렌글라이콜_소듐클로라이드_스테아릭애씨드_시트릭애씨드_실리카_아데노신_아스파틱애씨드_알라닌_에칠헥실글리세린_우레아_우릭애씨드_이소류신_이소스테아릭애씨드_이소프로필팔미테이트');
INSERT INTO `chemdb`.`product` (`productname`, `productnameK`, `productingredient`) VALUES ('Kamil HAND&NAIL CREAM', '카밀핸드N네일 클래식', '정제수_에칠헥실스테아레이트_글리세린_세테아릴알코올_페녹시에탄올_스테아릭애씨드_팔미틱애씨드_벤질알코올_디메치콘_부틸렌글라이콜_리날룰_캐모마일꽃추출물_부틸페닐메칠프로피오날_소듐하이드록사이드_벤질살리실레이트_리모넨_락틱애씨드_시트로넬올_알파-이소메칠이오논_소듐벤조에이트_신나밀알코올_시트랄_쿠마린_제라니올');
INSERT INTO `chemdb`.`product` (`productname`, `productnameK`, `productingredient`) VALUES ('DRAGON FRUIT Sun Essence SKINFOOD', '스킨푸드 드래곤 프룻 파워풀 선 에센스 SPF50+ PA++++', '정제수_에탄올_에칠헥실살리실레이트_사이클로펜타실록산_디부틸아디페이트_디프로필렌글라이콜_부틸렌글라이콜_세테스-10_데실글루코사이드_글리세린_사카라이드하이드롤리세이트_잔탄검_겨우살이잎추출물_마치현추출물_병풀추출물_용과추출물_치아씨추출물_소듐하이알루로네이트_에칠헥실글리세린_페녹시에탄올');
INSERT INTO `chemdb`.`product` (`productname`, `productnameK`, `productingredient`) VALUES ('GOLD COLLAGEN LUXURY BASE BASE DE LUXE', '더페이스샵 골드 콜라겐 럭셔리 베이스', '정제수_부틸렌글라이콜_변성알코올_디프로필렌글라이콜_나이아신아마이드_글리세릴폴리메타크릴레이트_금_글리세린_디메치콘_셀룰로오스검_하이드로제네이티드레시틴_아데노신_슈크로오스디스테아레이트_디소듐이디티에이');
INSERT INTO `chemdb`.`product` (`productname`, `productnameK`, `productingredient`) VALUES ('PHYSIOGEL HYPOALLERGENIC DAILY MOISTURE', '피지오겔 DMT 페이셜 크림', '정제수_글리세린_코코넛오일_쉐어버터_하이드록시에칠셀룰로오스_스쿠알란_잔탄검');
INSERT INTO `chemdb`.`product` (`productname`, `productnameK`, `productingredient`) VALUES ('TSUBAKI DAMAGE CARE', '츠바키 데미지케어 트리트먼트', '정제수_소르비톨_디메치콘_디프로필렌글라이콜_디글리세린_베헨트리모늄클로라이드_세틸알코올_이소프로필알코올_소듐벤조에이트_글루타믹애씨드_스테아트리모늄클로라이드_에탄올_메칠파라벤_페녹시에탄올_동백오일_부틸렌글라이콜_적색227호_토코페롤');
INSERT INTO `chemdb`.`product` (`productname`, `productnameK`, `productingredient`) VALUES ('LANCOME ABSOLUTE PRECIOUS CELLS', '랑콤 압솔뤼 프레셔스 셀 올레오 세럼', '정제수_글리세린_부틸렌글라이콜_변성알코올_디메치콘_메칠글루세스-20_티타늄디옥사이드_녹색201호_소듐하이알루로네이트_소듐하이드록사이드_하이드롤라이즈드콩단백질_페녹시에탄올_아데노신_실리카_디메칠이소소바이드_유차나무씨오일_리모넨_잔탄검_리날룰_디소듐이디티에이_시트로넬올_시트랄_쿠마린_소듐벤조에이트_바바수씨오일_레몬껍질오일');
INSERT INTO `chemdb`.`product` (`productname`, `productnameK`, `productingredient`) VALUES ('NUXE Lotion tonique dounce', '눅스 페탈로즈 토너', '정제수_다마스크장미꽃수_위치하젤수_글리세린_리날룰_벤질알코올_카프릴로일글라이신_시트릭애씨드_소듐하이드록사이드_알란토인_데하이드로아세틱애씨드_소듐하이알루로네이트');
INSERT INTO `chemdb`.`product` (`productname`, `productnameK`, `productingredient`) VALUES ('Mamonde ROSE WATER toner', '마몽드 로즈워터 토너', '장미추출물_부틸렌글라이콜_매실추출물_연꽃추출물_글리세린_에칠헥실글리세린_페녹시에탄올');
INSERT INTO `chemdb`.`product` (`productname`, `productnameK`, `productingredient`) VALUES ('Mamonde Creamy Tint Color Balm', '마몽드 크리미 틴트 컬러 밤', '라놀린_페트롤라툼_이소프로필라놀레이트_비즈왁스_오조케라이트_라놀린알코올_마이크로크리스탈린왁스_티타늄디옥사이드_아르간트리커넬오일_페녹시에탄올_적색223호_적색201호');
INSERT INTO `chemdb`.`product` (`productname`, `productnameK`, `productingredient`) VALUES ('Water Glow GelFoundation LANEIGE', '라네즈 워터글로우 젤 파운데이션', '정제수_부틸렌글라이콜_이소스테아릴알코올_부틸렌글라이콜코코에이트_글리세린_잔탄검_글리세릴카프릴레이트_에칠셀룰로오스_토코페롤_페녹시에탄올_리모넨_리날룰_부틸페닐메칠프로피오날_시트랄');
INSERT INTO `chemdb`.`product` (`productname`, `productnameK`, `productingredient`) VALUES ('LIRIKOS WRINKLE DESIGN LIQUID PACT', '리리코스 링클 디자인 리퀴드 팩트 SPF50+/ PA+++', '정제수_징크옥사이드_글리세린_에칠헥실메톡시신나메이트_티타늄디옥사이드_세틸에칠헥사노에이트_디메치콘_부틸렌글라이콜_나이아신아마이드_갈조추출물_글리세릴카프릴레이트_다이아몬드가루_디소듐이디티에이_매실추출물_백화사설초추출물_베타-글루칸_사이클로펜타실록산_소듐클로라이드_소듐 하이알루로네이트_스테아릭애씨드_실리카디메칠실릴레이트_아데노신_알지닌피씨에이_에칠헥실글리세린_에탄올_에톡시디글라이콜_에피갈로카테킨갈레이트_연꽃추출물_자작나무수 액_잔탄검');
INSERT INTO `chemdb`.`product` (`productname`, `productnameK`, `productingredient`) VALUES ('natural HAPPY BATH Pure CottonFlower Perfume Shower of Nature', '해피바스 퓨어 코튼플라워 퍼퓸 바디워시', '정제수_소듐라우레스설페이트_소르비톨_목화추출물_캐모마일꽃추출물_위치하젤잎추출물_우뭇가사리추출물_석류추출물_구기자추출물_라즈베리추출물_블루베리추출물_아사이야자추출물_오디추출물_산자나무열매추출물_댕댕이나무열매즙_라우릴글루코사이드_소듐시트레이트_디소듐이디티에이_소듐클로라이드_부틸렌글라이콜_글리세린_소듐설파이트,시트릭애씨드_페녹시에탄올_소듐벤조에이트');
INSERT INTO `chemdb`.`product` (`productname`, `productnameK`, `productingredient`) VALUES ('LANEIGE Mini Pore Waterclay Mask', '라네즈 미니포어 워터클레이 마스크', '정제수_씨실트_글리세린_에탄올_페퍼민트추출물_구주소나무싹추출물_피토스핑고신_글리세릴카프릴레이트_레시틴_세틸알코올_셀룰로오스검_에칠헥실글리세린_잔탄검_티타늄디옥사이드_디소듐이디티에이_페녹시에탄올');
INSERT INTO `chemdb`.`product` (`productname`, `productnameK`, `productingredient`) VALUES ('LIP CARE CREAM SHEA BUTTER 12g 042oz', '더페이스샵 립 케어 크림 시어버터', '페트롤라툼_미네랄오일_디이소스테아릴말레이트_실리카디메칠실릴레이트_쉐어버터_실리카실릴레이트_토코페롤_데하이드로아세틱애씨드');
INSERT INTO `chemdb`.`product` (`productname`, `productnameK`, `productingredient`) VALUES ('PETIT BIJOU BabyBubble All Over Spray', '에뛰드하우스 쁘띠비쥬 베이비버블 올오버 스프레이', '정제수_에탄올_에칠헥실메톡시신나메이트_알파-이소메칠이오논_벤질살리실레이트_부틸페닐메칠프로피오날_신나밀알코올_쿠마린_제라니올_리모넨_리날룰');
