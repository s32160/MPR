
@SpringBootApplication
public class Main {
    private final KontoStorage kontoStorage;
    private final KontoService kontoService;

    public Main(KontoStorage kontoStorage, KontoService kontoService) {
        this.kontoStorage = kontoStorage;
        this.kontoService = kontoService;
    }

    public static void main(String[] args) {
        SpringApplication.run(Main.class, args);
    }

    public void initProcess() {
        Konto konto1 = new Konto(1, 2323);
        Konto konto2 = new Konto(2, 3321);
        Konto konto3 = new Konto(3, 2043);

        kontoStorage.addKonto(konto1);
        kontoStorage.addKonto(konto2);
        kontoStorage.addKonto(konto3);
    }
}
