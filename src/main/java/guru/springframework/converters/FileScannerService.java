package guru.springframework.converters;


public interface FileScannerService {

    boolean startFileScanner();
    
    public void executeScanner(String mod) throws Exception;

	void stopFileScanner();

}
