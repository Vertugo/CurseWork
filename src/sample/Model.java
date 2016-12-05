package sample;

import sample.entity.*;
import sample.entity.enums.TypeOfMemory;
import sample.entity.enums.TypeRam;
import sun.reflect.generics.tree.Tree;

import java.net.URI;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;

/**
 * Created by Alex on 02.12.2016.
 */
public class Model {
    private final String URL = "jdbc:mysql://localhost:3306/automatic_system";
    private final String PASSWORD = "root";
    private final String USERNAME = "root";
    /**
     * Ниже перечислены запросы для извлечения всех товаров даного комплектующего
     */
    private final String queryCPU = "SELECT * FROM cpus";
    private final String queryVideoCard = "SELECT * FROM video_card";
    private final String queryHDD = "SELECT * FROM hdd";
    private final String queryMotherBoard = "SELECT * FROM mother_board";
    private final String queryRam = "SELECT * FROM ram";
    private final String queryHousing = "SELECT * FROM housing";
    /**
     * Запросы для поиска по имени комплектующего
     */
    private final String searchCPU = "SELECT * FROM cpus WHERE cpu_name = ";
    private final String searchVideoCard = "SELECT * FROM video_card where video_name = ";
    private final String searchRam = "SELECT * FROM ram WHERE ram_name = ";
    private final String searchMotherBoard = "SELECT * FROM mother_board where mother_board_name = ";
    private final String searchHousing = "SELECT * FROM housing WHERE housing_name = ";
    private final String searchHDD = "SELECT * FROM hdd WHERE hdd_name = ";

    private TreeSet<VideoCard> videoCards;
    private TreeSet<CPU> cpuSet;
    private TreeSet<HDD> hddSet;
    private TreeSet<MotherBoard> motherBoardSet;
    private TreeSet<RAM> ramSet;
    private TreeSet<Housing> housingSet;

    public Model() {
        this.videoCards = new TreeSet<>();
        this.cpuSet = new TreeSet<>();
        this.hddSet = new TreeSet<>();
        this.motherBoardSet = new TreeSet<>();
        this.ramSet = new TreeSet<>();
        this.housingSet = new TreeSet<>();
    }

    public TreeSet<VideoCard> getVideoCards(){
        TExecutor tExecutor = new TExecutor();

        if(!videoCards.isEmpty()){
            videoCards.clear();
        }

        try(Connection connection = DriverManager.getConnection(URL,USERNAME,PASSWORD)) {
            this.videoCards = tExecutor.execQuery(connection,queryVideoCard,resultSet ->{
                while (resultSet.next()){
                    String name = resultSet.getString("video_name");
                    String the_graphics_chip = resultSet.getString("the_graphics_chip");
                    int memory_frequency = resultSet.getInt("memory_frequency");
                    int core_clock = resultSet.getInt("core_clock");
                    double memory_size = resultSet.getDouble("memory_size");
                    int bit_memory_bus = resultSet.getInt("bit_memory_bus");
                    TypeOfMemory typeOfMemory = TypeOfMemory.valueOf(resultSet.getString("type_of_memory"));
                    int guarantee = resultSet.getInt("guarantee");
                    double price = resultSet.getDouble("price");

                    videoCards.add(new VideoCard(name,the_graphics_chip,memory_frequency,core_clock,memory_size,bit_memory_bus,typeOfMemory,guarantee,price));
                }
                return this.videoCards;
            } );
        }catch (SQLException e){
            e.printStackTrace();
        }
        return this.videoCards;
    }

    public Set<CPU> getCpuSet(){
        TExecutor tExecutor = new TExecutor();

        if(!cpuSet.isEmpty()){
            cpuSet.clear();
        }

        try(Connection connection = DriverManager.getConnection(URL,USERNAME,PASSWORD)) {
            this.cpuSet = tExecutor.execQuery(connection,queryCPU,resultSet ->{
                while (resultSet.next()){
                    String name = resultSet.getString("cpu_name");
                    String connector_type = resultSet.getString("connector_type");
                    int number_of_cores = resultSet.getInt("number_of_cores");
                    int internal_clock_rate = resultSet.getInt("internal_clock_rate");
                    String the_unlocked_multiplier = resultSet.getString("the_unlocked_multiplier");
                    double frequency = resultSet.getDouble("the_frequency_of_the_data_bus");
                    int number_of_contacts = resultSet.getInt("number_of_contacts");
                    int TDP_power = resultSet.getInt("TDP_power");
                    String kernel_name = resultSet.getString("kernel_name");
                    int guarantee = resultSet.getInt("guarantee");
                    double price = resultSet.getDouble("price");

                    this.cpuSet.add(new CPU(name,connector_type,number_of_cores,internal_clock_rate,the_unlocked_multiplier,
                            frequency,number_of_contacts,TDP_power,kernel_name,guarantee,price));
                }

                return this.cpuSet;
            } );
        }catch (SQLException e){
            e.printStackTrace();
        }
        return this.cpuSet;
    }

    public TreeSet<HDD> getHddSet(){
        TExecutor tExecutor = new TExecutor();

        if(!hddSet.isEmpty()){
            hddSet.clear();
        }

        try(Connection connection = DriverManager.getConnection(URL,USERNAME,PASSWORD)) {
            this.hddSet = tExecutor.execQuery(connection,queryHDD,resultSet -> {
                while (resultSet.next()){
                    String name = resultSet.getString("hdd_name");
                    int capacity = resultSet.getInt("capacity_hdd");
                    String interface_hdd = resultSet.getString("interface");
                    int the_volume_of_buffer = resultSet.getInt("the_volume_of_buffer");
                    int the_data_rate = resultSet.getInt("the_data_rate");
                    int guarantee = resultSet.getInt("guarantee");
                    double price = resultSet.getDouble("price");

                    this.hddSet.add(new HDD(name,capacity,interface_hdd,the_volume_of_buffer,the_data_rate,guarantee,
                            price));
                }
                return this.hddSet;
            });
        }catch (SQLException e){
            e.printStackTrace();
        }

        return this.hddSet;
    }

    public TreeSet<MotherBoard> getMotherBoardSet(){
        TExecutor tExecutor = new TExecutor();

        try(Connection connection = DriverManager.getConnection(URL,USERNAME,PASSWORD)){
            this.motherBoardSet = tExecutor.execQuery(connection,queryMotherBoard,resultSet -> {
                while (resultSet.next()){
                    String name = resultSet.getString("mother_board_name");
                    String connector_type = resultSet.getString("connector_type");
                    String chipset = resultSet.getString("chipset");
                    String physical_dimension = resultSet.getString("physical_dimensions");
                    int guarantee = resultSet.getInt("guarantee");
                    double price = resultSet.getDouble("price");


                    this.motherBoardSet.add(new MotherBoard(name,connector_type,chipset,physical_dimension,guarantee,price));
                }
                return this.motherBoardSet;
            });
        }catch (SQLException e){
            e.printStackTrace();
        }
        return this.motherBoardSet;
    }

    public TreeSet<RAM> getRamSet(){
        TExecutor tExecutor = new TExecutor();

        try(Connection connection = DriverManager.getConnection(URL,USERNAME,PASSWORD)){
            this.ramSet = tExecutor.execQuery(connection,queryRam,resultSet ->{
                while (resultSet.next()){
                    String name = resultSet.getString("ram_name");
                    int memory_size = resultSet.getInt("memory_size");
                    TypeRam typeRam = TypeRam.valueOf(resultSet.getString("type_of_memory").replaceAll(" ",""));
                    double supply_voltage = resultSet.getDouble("supply_voltage");
                    int memory_frequency = resultSet.getInt("memory_frequency");
                    int effective_bandwidth = resultSet.getInt("effective_bandwidth");
                    int number_of_strips = resultSet.getInt("number_of_strips");
                    int guarantee = resultSet.getInt("guarantee");
                    double price = resultSet.getDouble("price");

                    this.ramSet.add(new RAM(name,memory_size,typeRam,supply_voltage,memory_frequency,effective_bandwidth,
                            number_of_strips,guarantee,price));
                }
                return this.ramSet;
            } );
        }catch (SQLException e){
            e.printStackTrace();
        }
        return this.ramSet;
    }

    public TreeSet<Housing> getHousingSet(){
        TExecutor tExecutor = new TExecutor();

        try(Connection connection = DriverManager.getConnection(URL,USERNAME,PASSWORD)){
            this.housingSet = tExecutor.execQuery(connection,queryHousing,resultSet -> {
                while (resultSet.next()){
                    String name = resultSet.getString("housing_name");
                    String material = resultSet.getString("housing_material");
                    String type = resultSet.getString("type_of_housing");
                    int guarantee = resultSet.getInt("guarantee");
                    double price = resultSet.getDouble("price");

                    this.housingSet.add(new Housing(name,material,type,guarantee,price));
                }
                return this.housingSet;
            });
        }catch (SQLException e){
            e.printStackTrace();
        }
        return this.housingSet;
    }

    public TreeSet<CPU> searchCPU(String search){
        TExecutor tExecutor = new TExecutor();
        TreeSet<CPU> tempCPUTreeSet = new TreeSet<>();
        try(Connection connection = DriverManager.getConnection(URL,USERNAME,PASSWORD)){
            tempCPUTreeSet = tExecutor.execQuery(connection,searchCPU + "'" + search + "'",resultSet -> {
                TreeSet<CPU> set = new TreeSet<CPU>();
                while (resultSet.next()){
                    String name = resultSet.getString("cpu_name");
                    if(search.equals(name)){
                        String connector_type = resultSet.getString("connector_type");
                        int number_of_cores = resultSet.getInt("number_of_cores");
                        int internal_clock_rate = resultSet.getInt("internal_clock_rate");
                        String the_unlocked_multiplier = resultSet.getString("the_unlocked_multiplier");
                        double frequency = resultSet.getDouble("the_frequency_of_the_data_bus");
                        int number_of_contacts = resultSet.getInt("number_of_contacts");
                        int TDP_power = resultSet.getInt("TDP_power");
                        String kernel_name = resultSet.getString("kernel_name");
                        int guarantee = resultSet.getInt("guarantee");
                        double price = resultSet.getDouble("price");

                        set.add(new CPU(name,connector_type,number_of_cores,internal_clock_rate,the_unlocked_multiplier,
                                frequency,number_of_contacts,TDP_power,kernel_name,guarantee,price));
                    }else continue;
                }
                return set;
            });
        }catch (SQLException e){
            e.printStackTrace();
        }
        return tempCPUTreeSet;
    }

    public TreeSet<VideoCard> searchVideoCard(String search){
        TExecutor tExecutor = new TExecutor();
        TreeSet<VideoCard> tempVideoCardSet = new TreeSet<>();
        try(Connection connection = DriverManager.getConnection(URL,USERNAME,PASSWORD)){
            tempVideoCardSet = tExecutor.execQuery(connection,searchVideoCard + "'" + search + "'",resultSet -> {
                TreeSet<VideoCard> set = new TreeSet<VideoCard>();
                while (resultSet.next()){
                    String name = resultSet.getString("video_name");
                    if(name.equals(search)){
                        String the_graphics_chip = resultSet.getString("the_graphics_chip");
                        int memory_frequency = resultSet.getInt("memory_frequency");
                        int core_clock = resultSet.getInt("core_clock");
                        double memory_size = resultSet.getDouble("memory_size");
                        int bit_memory_bus = resultSet.getInt("bit_memory_bus");
                        TypeOfMemory typeOfMemory = TypeOfMemory.valueOf(resultSet.getString("type_of_memory"));
                        int guarantee = resultSet.getInt("guarantee");
                        double price = resultSet.getDouble("price");

                        set.add(new VideoCard(name,the_graphics_chip,memory_frequency,core_clock,memory_size,
                                bit_memory_bus,typeOfMemory,guarantee,price));
                    }else continue;
                }
                return set;
            });
        }catch (SQLException e){
            e.printStackTrace();
        }
        return tempVideoCardSet;
    }

    public TreeSet<RAM> searchRam(String search){
        TExecutor tExecutor = new TExecutor();
        TreeSet<RAM> searchSet = new TreeSet<>();

        try(Connection connection = DriverManager.getConnection(URL,USERNAME,PASSWORD)){
        searchSet = tExecutor.execQuery(connection,searchRam + "'" + search + "'",resultSet -> {
            TreeSet<RAM> set = new TreeSet<RAM>();
            while (resultSet.next()){
                String name = resultSet.getString("ram_name");
                if(name.equals(search)){
                    int memory_size = resultSet.getInt("memory_size");
                    TypeRam typeRam = TypeRam.valueOf(resultSet.getString("type_of_memory").replaceAll(" ",""));
                    double supply_voltage = resultSet.getDouble("supply_voltage");
                    int memory_frequency = resultSet.getInt("memory_frequency");
                    int effective_bandwidth = resultSet.getInt("effective_bandwidth");
                    int number_of_strips = resultSet.getInt("number_of_strips");
                    int guarantee = resultSet.getInt("guarantee");
                    double price = resultSet.getDouble("price");

                    set.add(new RAM(name,memory_size,typeRam,supply_voltage,memory_frequency,effective_bandwidth,
                            number_of_strips,guarantee,price));
                }else  continue;
            }
            return set;
        });
        }catch (SQLException e){
            e.printStackTrace();
        }
        return searchSet;
    }

    public TreeSet<MotherBoard> searchMotherBoard(String search){
        TExecutor tExecutor = new TExecutor();
        TreeSet<MotherBoard> searchSet = new TreeSet<>();

        try(Connection connection = DriverManager.getConnection(URL,USERNAME,PASSWORD)){
            searchSet = tExecutor.execQuery(connection,searchMotherBoard + "'" + search + "'",resultSet -> {
                TreeSet<MotherBoard> set = new TreeSet<>();
                while (resultSet.next()){
                    String name = resultSet.getString("mother_board_name");
                    if(name.equals(search)){
                        String connector_type = resultSet.getString("connector_type");
                        String chipset = resultSet.getString("chipset");
                        String physical_dimension = resultSet.getString("physical_dimensions");
                        int guarantee = resultSet.getInt("guarantee");
                        double price = resultSet.getDouble("price");

                        set.add(new MotherBoard(name,connector_type,chipset,physical_dimension,
                                guarantee,price));
                    }
                }
                return set;
            });
        }catch (SQLException e){
            e.printStackTrace();
        }
        return searchSet;
    }

    public TreeSet<Housing> searchHousing(String search){
        TExecutor tExecutor = new TExecutor();
        TreeSet<Housing> searchHousingSet = new TreeSet<>();

        try(Connection connection = DriverManager.getConnection(URL,USERNAME,PASSWORD)){
            searchHousingSet = tExecutor.execQuery(connection,searchHousing + "'" + search + "'",resultSet -> {
                TreeSet<Housing> set = new TreeSet<Housing>();
                while (resultSet.next()){
                    String name = resultSet.getString("housing_name");
                    if(name.equals(search)){
                        String material = resultSet.getString("housing_material");
                        String type = resultSet.getString("type_of_housing");
                        int guarantee = resultSet.getInt("guarantee");
                        double price = resultSet.getDouble("price");

                        set.add(new Housing(name,material,type,guarantee,price));
                    }else continue;
                }
                return set;
            } );
        }catch (SQLException e){
            e.printStackTrace();
        }
        return searchHousingSet;
    }

    public TreeSet<HDD> searchHDD(String search){
        TExecutor tExecutor = new TExecutor();
        TreeSet<HDD> searchSet = new TreeSet<>();

        try(Connection connection = DriverManager.getConnection(URL,USERNAME,PASSWORD)) {
            searchSet = tExecutor.execQuery(connection,searchHDD + "'" + search + "'",resultSet -> {
                TreeSet<HDD> set = new TreeSet<HDD>();
                while (resultSet.next()){
                    String name = resultSet.getString("hdd_name");
                    if(name.equals(search)){
                        int capacity = resultSet.getInt("capacity_hdd");
                        String interface_hdd = resultSet.getString("interface");
                        int the_volume_of_buffer = resultSet.getInt("the_volume_of_buffer");
                        int the_data_rate = resultSet.getInt("the_data_rate");
                        int guarantee = resultSet.getInt("guarantee");
                        double price = resultSet.getDouble("price");

                        set.add(new HDD(name,capacity,interface_hdd,the_volume_of_buffer,the_data_rate,
                                guarantee,price));
                    }else continue;
                }
                return set;
            });
        }catch (SQLException e){
            e.printStackTrace();
        }
        return searchSet;
    }
}
