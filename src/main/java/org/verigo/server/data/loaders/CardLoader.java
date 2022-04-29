package org.verigo.server.data.loaders;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;
import org.verigo.server.data.entities.Card;
import org.verigo.server.data.repositories.CardRepository;
import org.verigo.server.data.repositories.CategoryRepository;

@Component
@Order(5)
public class CardLoader implements CommandLineRunner {
    private final CardRepository repository;
    private final CategoryRepository categoryRepository;

    @Autowired
    public CardLoader(CardRepository repository, CategoryRepository categoryRepository) {
        this.repository = repository;
        this.categoryRepository = categoryRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        if (repository.count() == 0) {
            //Animal (set A)
            Card card = new Card("cat", "кот", "c96ae2c66c6c587b4c270bbcdc841374_lzrgo1", "f695aeb52ee4f496f2fc1dd615df3c3d_gmwk97");
            card.setCategory(categoryRepository.findById(1).get());
            this.repository.save(card);
            card = new Card("dog", "собака", "7078cb1ddfae8885e445071b310f9ee5_wu9uul", "48462b9804acd23d44ba26945bf7ec1a_bvceys");
            card.setCategory(categoryRepository.findById(1).get());
            this.repository.save(card);
            card = new Card("chicken", "курица", "aeb3472aec8aa5ad616e16a1f42d4fb2_frdp1y", "b2484431a6a912bdefd838336ca2ae54_nszzxv");
            card.setCategory(categoryRepository.findById(1).get());
            this.repository.save(card);
            card = new Card("chick", "цыплёнок", "9d2558e917c99512bc949c8ccef8e3dc_ilcfiu", "239024ff33d53982b6ecc34dd237d10c_tt9rux");
            card.setCategory(categoryRepository.findById(1).get());
            this.repository.save(card);
            card = new Card("horse", "лошадь", "fd141daf933667b9c7ff0b13400c1967_jurzce", "05f3240e18c33aec37b748f470d10943_oqs3a7");
            card.setCategory(categoryRepository.findById(1).get());
            this.repository.save(card);
            card = new Card("pig", "свинья", "f7381c4a1f85765b322bb50776b90e27_av7kcn", "cf66a76c205ca89e1adc373c16a06c58_amaxqy");
            card.setCategory(categoryRepository.findById(1).get());
            this.repository.save(card);
            card = new Card("sheep", "овца", "6ce68c29692d0dfa3c1e2a4cbadc361b_jh4i67", "a09a38d5919e9e714df018995bd9401a_gjfo5v");
            card.setCategory(categoryRepository.findById(1).get());
            this.repository.save(card);
            card = new Card("rabbit", "кролик", "2b4d98d43e597974eb7ff5b262f55828_flb7kf", "61b584cb139b35e12f9089504d1498d6_xfcant");
            card.setCategory(categoryRepository.findById(1).get());
            this.repository.save(card);

            //Animal (set B)
            card = new Card("bird", "птица", "e848cde536b566403470dd6ecb941660_pjcofg", "9a26366bda96e3e15b28712f34d5cf7f_gpt6rj");
            card.setCategory(categoryRepository.findById(2).get());
            this.repository.save(card);
            card = new Card("frog", "лягушка", "af71dbb105ee245a2b5b19a40f82ad17_m7reay", "db2b4f2a376d6bcd3dd74eb6ee5b1d52_wusm4j");
            card.setCategory(categoryRepository.findById(2).get());
            this.repository.save(card);
            card = new Card("giraffe", "жираф", "22ae30770a76383898e8ac4266456350_emwmaq", "555d337c64bc4e0894b436017d8bcd18_v8r8wm");
            card.setCategory(categoryRepository.findById(2).get());
            this.repository.save(card);

            //Animal (set C)
            card = new Card("tiger", "тигр", "3a5ac71dece3705877a997801963ad6d_ljxq0j", "f1e999ffe3d1ae5e53ebd06078938c2d_chaze4");
            card.setCategory(categoryRepository.findById(3).get());
            this.repository.save(card);
            card = new Card("rhino", "носорог", "4b4afb5211ccdd53e552be88b88aab17_yb7szv", "24a5860688b4c88007a9aaa8e6788963_snmwtx");
            card.setCategory(categoryRepository.findById(3).get());
            this.repository.save(card);
            card = new Card("platypus", "утконос", "9449e84e29e41d9216c54d84e2ae4d18_ipkqjl", "9bc3867512f2536488a2a083364b837f_snr1re");
            card.setCategory(categoryRepository.findById(3).get());
            this.repository.save(card);
            card = new Card("wolf", "волк", "e076496708e762cb8683ec5c8f39e1e0_oov9cd", "538b8d5c3de3e30d12c5a74aaf6d0a38_uegesq");
            card.setCategory(categoryRepository.findById(3).get());
            this.repository.save(card);

            //Action (set A)
            card = new Card("cry", "плакать", "d082cbfd53d05efac4e1517dbc18c873_fmuqap", "ace318966ecbb608e67de0603ade33fa_xg71my");
            card.setCategory(categoryRepository.findById(4).get());
            this.repository.save(card);
            card = new Card("dance", "танцевать", "72ae797ae26c6f46fcc7d0168672b9ed_rycoad", "0bd87bc93c2b4ae33ef019c844d36685_xdvd10");
            card.setCategory(categoryRepository.findById(4).get());
            this.repository.save(card);
            card = new Card("dive", "нырять", "7162806ff3b48595451d5564e79798b5_utrhbp", "ebd1369b207d507ef3035834fdcce8c3_gngjo0");
            card.setCategory(categoryRepository.findById(4).get());
            this.repository.save(card);
            card = new Card("draw", "рисовать", "fecc29490d62561146062b08f22d69ba_ntf3v2", "693f80baeb3c2e6b339e3a5b4af52a07_rga3ha");
            card.setCategory(categoryRepository.findById(4).get());
            this.repository.save(card);
            card = new Card("fish", "ловить рыбу", "c636c7ebf9f11591070749be775a948d_v2utjs", "043bb35531531369de82601788630e3f_yxbjuc");
            card.setCategory(categoryRepository.findById(4).get());
            this.repository.save(card);
            card = new Card("fly", "летать", "0164232dcda2e9b7b5d62ff40e77e16f_jb8iej", "76f5b057200ffd2f6ca9eaba1a71ed9f_frr4ip");
            card.setCategory(categoryRepository.findById(4).get());
            this.repository.save(card);
            card = new Card("hug", "обнимать", "1c5075e63327ba5dda25e8cefc89711d_arjail", "2ee0adcfc0a1456ac72662834c09d6d4_u5b3um");
            card.setCategory(categoryRepository.findById(4).get());
            this.repository.save(card);
            card = new Card("jump", "прыгать", "335a4d67d623210af6f61e12376bf610_atf2sx", "8173836a3b3b02277fded897da5fae93_izhzeh");
            card.setCategory(categoryRepository.findById(4).get());
            this.repository.save(card);

            //Action (set B)
            card = new Card("open", "открывать", "b47fe09367b9c1e36211f9565c9a5ea9_y4g5yn", "56624b571259b1b7c3f1d8e42df3bbb1_krpcfq");
            card.setCategory(categoryRepository.findById(5).get());
            this.repository.save(card);
            card = new Card("point", "указывать", "8081d868db85abefcb550515c12f3e22_p7m6st", "8dff2393826f1037d6b263612328503d_ipxxen");
            card.setCategory(categoryRepository.findById(5).get());
            this.repository.save(card);
            card = new Card("play", "играть", "30bae27b2da802868252386abdf0c20e_ymjnuq", "179e374a0ddb569d0a600adfe3104919_gjhbge");
            card.setCategory(categoryRepository.findById(5).get());
            this.repository.save(card);
            card = new Card("ride", "ездить", "f06e9aea511a73169de59d22b1b74a21_n4zvbk", "1b3b03f926285584d02aeef59b65e8ff_cjptzd");
            card.setCategory(categoryRepository.findById(5).get());
            this.repository.save(card);
            card = new Card("run", "бегать", "d63b742854ef2049df2111a1c5185cd7_f05cmz", "5290c0a31ac1c68c0ae00c3e1daa67bb_yzyn6i");
            card.setCategory(categoryRepository.findById(5).get());
            this.repository.save(card);

            //Emotions
            card = new Card("sad", "грустный", "d0c5bcb42c19ce580b5c12310c7bd3b8_mb5yq6", "b15f280bfc770cf6f386daea39c093e5_jwbx44");
            card.setCategory(categoryRepository.findById(6).get());
            this.repository.save(card);
            card = new Card("angry", "сердитый", "aa95b6b4c750decafe3d4041f5ad68ab_rmcjmp", "1a688264bfc9b241a528f9a5dc7f7db9_is3t2y");
            card.setCategory(categoryRepository.findById(6).get());
            this.repository.save(card);
            card = new Card("happy", "счастливый", "f367c73cbedd3a37b23c56711c4fb448_jo2con", "e0cc02fd994df6a966a7f5e1eae9edb7_kckbch");
            card.setCategory(categoryRepository.findById(6).get());
            this.repository.save(card);
            card = new Card("tired", "уставший", "be22663eef6598f24441059cd90ab1f0_h5m9ze", "e1034b120dfb9dd2873e3a1afc29c30a_hyownl");
            card.setCategory(categoryRepository.findById(6).get());
            this.repository.save(card);
            card = new Card("surprised", "удивлённый", "f1a19adbd039adb8942f39264c92708e_di1gk4", "43d69a8955418518a03534db134004e6_ywmi85");
            card.setCategory(categoryRepository.findById(6).get());
            this.repository.save(card);
            card = new Card("scared", "испуганный", "616ceb632a4a2bd029cbf6b7201201ad_y7i1sq", "70450948f05414585e605c3029b0650d_mrj039");
            card.setCategory(categoryRepository.findById(6).get());
            this.repository.save(card);
            card = new Card("smile", "улыбка", "9923abd5af3c480b2d1419fa550b6631_cw5bno", "a086ba9d4a4866265ee91cc1842b10ec_xj2uuh");
            card.setCategory(categoryRepository.findById(6).get());
            this.repository.save(card);
            card = new Card("laugh", "смех", "ad74c7d4d75272ea131ae7294f60bb71_hgnjd9", "a817d593f95c3b2aa3d893dc773b215d_y7e0s0");
            card.setCategory(categoryRepository.findById(6).get());
            this.repository.save(card);

            //Fruits
            card = new Card("orange", "апельсин", "46c059c9820de54561f41beb126e68b3_nlpb82", "f0042357e2ce8f7bc0d713ea3b3c500f_kq9zki");
            card.setCategory(categoryRepository.findById(7).get());
            this.repository.save(card);
            card = new Card("banana", "банан", "c5a30791920284dbac772c718e193d79_f2xd98", "f31dee64fff559568381aee08d3f0ad0_wbbap9");
            card.setCategory(categoryRepository.findById(7).get());
            this.repository.save(card);
            card = new Card("peach", "персик", "801bf5ecbf14d2eb4487018d3f4a86af_fjxaeq", "144927232fc24ecc5979915d94fb37ee_jzgyfy");
            card.setCategory(categoryRepository.findById(7).get());
            this.repository.save(card);
            card = new Card("lemon", "лимон", "ac792e7b6c367fdc605b255672a40c94_jp7ol6", "b013e45d6d865a730a87e18b59fcbe0b_jez4ni");
            card.setCategory(categoryRepository.findById(7).get());
            this.repository.save(card);
            card = new Card("apple", "яблоко", "b2dfdfbedf826307d97348c0432f28a0_lffybq", "ac0d71e29e4a502896f9091d8eb0d59c_f5tggh");
            card.setCategory(categoryRepository.findById(7).get());
            this.repository.save(card);
            card = new Card("pineapple", "ананас", "b42629d08be950a79aa110553549ab1d_blmjrs", "2be20c3e811c3df26fa175d8a27f1593_bwukxs");
            card.setCategory(categoryRepository.findById(7).get());
            this.repository.save(card);
            card = new Card("tangerine", "мандарин", "187adcda3d15a66b5977b6601c8ce53f_thocbd", "a36cc2d365b7370f86013ba211c96f87_bg4mis");
            card.setCategory(categoryRepository.findById(7).get());
            this.repository.save(card);
            card = new Card("pear", "груша", "680fc110e9c16c0ff0e31b452aac9ef2_zxgv7s", "1fe56b3491f2b9ab0b0940c324190d76_exkfb2");
            card.setCategory(categoryRepository.findById(7).get());
            this.repository.save(card);

            //Clothes
            card = new Card("blouse", "блузка", "3b90154bba6aeb86c78f663a5624443e_dle5yt", "4391e1d4cf5761be85e66d2fc86cb21a_lmxuzt");
            card.setCategory(categoryRepository.findById(8).get());
            this.repository.save(card);
            card = new Card("boot", "ботинок", "15862d4d95f9f3c172dbb7f6b4229964_ruyf43", "153e4f85b51bf04743ea7f4a8066bfc6_fpmww7");
            card.setCategory(categoryRepository.findById(8).get());
            this.repository.save(card);
            card = new Card("shirt", "рубашка", "8b05e180270ed7983cd703baa93f8163_ery2he", "11ba29e128bfcf5dbc6649af62110df2_ikqsxh");
            card.setCategory(categoryRepository.findById(8).get());
            this.repository.save(card);
            card = new Card("skirt", "юбка", "1bad8f127643ee58ef431871931b6cd7_zsqmhk", "7172e35e00ee0c78754c5a639e6ece23_cbnwa7");
            card.setCategory(categoryRepository.findById(8).get());
            this.repository.save(card);
            card = new Card("sneakers", "кроссовки", "13237687551650697be8b5a893ebc87b_ggi0m7", "3f60f3cb57712c53b7005dbee08628c6_bnrqaf");
            card.setCategory(categoryRepository.findById(8).get());
            this.repository.save(card);
            card = new Card("pants", "брюки", "fa59bbdfdb27504df3d57fd4b6341cab_eowrsf", "c0c62bd0d3dc8e176e5305aa5747d2e2_rc650b");
            card.setCategory(categoryRepository.findById(8).get());
            this.repository.save(card);
            card = new Card("dress", "платье", "647838c0bda21d60719ad5fde6d0274c_rvkss9", "42cb68e3661f2808be3ce0fe64307fab_gn3bwr");
            card.setCategory(categoryRepository.findById(8).get());
            this.repository.save(card);
            card = new Card("coat", "пальто", "3a7c7e62f50ce9e337cb15d2cb119187_zdelaa", "1d09baa0635cc1980a544729bee3b2e6_lan2ur");
            card.setCategory(categoryRepository.findById(8).get());
            this.repository.save(card);
            card = new Card("shoes", "туфли", "abaf86c195252b760425b0e24a6c5c29_hg1l0i", "37bc4b976ae8b55ae9529e9915f2c614_ocwe6c");
            card.setCategory(categoryRepository.findById(8).get());
            this.repository.save(card);
        }
    }
}
