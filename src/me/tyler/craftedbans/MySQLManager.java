package me.tyler.craftedbans



public class MySQLManager {
    private final Craftedbans main;
private MySQL db;

    public MySQLManager(Craftedbans h) {
        this.main = h;
    }
  
    public void SetupDB() throws SQLException {
        this.db = new MySQL(this.main,"localhost","3306","Craftedbans",
                "root","pass");
        this.db.openConnection();
        Statement statement = this.db.getConnection().createStatement();
        statement
                .executeUpdate("CREATE TABLE IF NOT EXISTS `Craftedbanslog` (`Name` varchar(32), `Uses` int)");
        statement.close();
    }
    
    public void closeDB(){
        this.db.closeConnection();
    }
    
    public int getUses(Player p) throws SQLException {
        String pname = p.getDisplayName().toLowerCase();
        if(!this.db.checkConnection())
            this.db.openConnection();
        Statement statement = this.db.getConnection().createStatement();
        ResultSet rs = statement
        .executeQuery("SELECT * FROM `Craftedbanslog` WHERE `Name`='"
        +pname+"';");
        if(!rs.next())
        return 0;
    return rs getInt("Uses");
    }
    
    public void updatePlayer(Player p) throws SQLException
        String pname = p.getDisplayName().toLowerCase();
        if(!this.db.checkConnection())
            this.db.openConnection();
        Statement statement = this.db.getConnection().createStatement();
        int uses = this.getUses(p);
        if(uses!=0){
            statement.executeUpdate("UPDATE `Craftedbans` SET `Uses`='"+(uses+1)+' WHERE `Name`='"
                        +pname+"';");
        }else{
            statement.executeUpdate("INSERT INTO `Craftedbanslog` (`Name`,`Uses`) VALUES'"
                        + pname +"', '1');");
            }
        }
    
    }    
