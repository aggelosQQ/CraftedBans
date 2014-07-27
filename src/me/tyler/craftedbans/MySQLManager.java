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
        statement.executeUpdate("CREATE TABLE IF NOT EXISTS 'Craftedbanslog' ('Name' varchar(32), 'Uses' int)");
        statement.close();
    }
    
    public void closeDB(){
        this.db.closeConnection();
    }
    
}    
