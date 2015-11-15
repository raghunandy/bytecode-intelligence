/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bcintell.unziputility;

/**
 *
 * @author Piya
 */
public class UnzipUtilityTest {
    public static void main(String[] args) {
        String zipFilePath = "/Users/Piya/desktop/Cover Letter.zip";
        String destDirectory = "/Users/Piya/desktop";
        UnzipUtility unzipper = new UnzipUtility();
        try {
            unzipper.unzip(zipFilePath);
        } catch (Exception ex) {
            // if some errors occurred
            ex.printStackTrace();
        }
    }
}
