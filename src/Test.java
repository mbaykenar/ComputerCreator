/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Hasan
 */
public class Test {
    public static void main(String args[]) throws Exception{
        Cpu cpu = new Cpu(43.4, 4.1, 42, 32, "Cintel", "HasanG", 545.74);
        
        //cpu.insertCpu();
        
        //Cpu tempCpu = new Cpu();
        
        //tempCpu.retrieveCpu(8);
        
        Cpu.deleteCpu(8);
    }
}
