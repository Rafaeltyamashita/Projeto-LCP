import java.sql.*;
// Falta Logica para contar a linha de inserção
// Falta implementar outros bancos de dados
 public class BD {
    /**
     *
     * @param Nome
     */
    //exclui do banco de dados dependendo do nome
    public static void exclui(String Nome){
    try{
    Class.forName("org.hsqldb.jdbcDriver"); //acessa driver do banco de dados
    //estabelece conexão com o baco de dados
    Connection con = DriverManager.getConnection("jdbc:hsqldb:file:C:\\Users\\rafae\\Downloads\\Unesp\\LCP\\Projeto-LCP\\Banco de Dados\\BD", "sa", ""); //CAMPOS UR/Login/senha
    Statement stm= con.createStatement(); //criada instancia para trabalhar com instruções do banco de dados
    
    //Cria a statement para inserir os campos de Morador
    String INSERT_RECORD;
    INSERT_RECORD = "DELETE FROM Morador WHERE Nome = ? ";
    PreparedStatement pstmt = con.prepareStatement(INSERT_RECORD);
    pstmt.setString(1, Nome);
    pstmt.executeUpdate();//coloca a statement insery_record em executeUpdate para atualizar o valor
    
    stm.execute("SHUTDOWN");
    }catch(ClassNotFoundException e){
    System.out.println("Erro ao carregar o driver JDBC. ");
    }catch(SQLException e){
    System.out.println("Erro de SQL: "+e);    
    }
   }
   //muda campo previsao de saida
    public static void update_previsao_saida(Date previsao,String Nome){
    try{
    Class.forName("org.hsqldb.jdbcDriver"); //acessa driver do banco de dados
    //estabelece conexão com o baco de dados
    Connection con = DriverManager.getConnection("jdbc:hsqldb:file:C:\\Users\\rafae\\Downloads\\Unesp\\LCP\\Projeto-LCP\\Banco de Dados\\BD", "sa", ""); //CAMPOS UR/Login/senha
    Statement stm= con.createStatement(); //criada instancia para trabalhar com instruções do banco de dados
    
    //Cria a statement para inserir os campos de Morador
    String INSERT_RECORD;
    INSERT_RECORD = "UPDATE Morador SET DATA_SAIDA = ? where nome = ?";
    
    PreparedStatement pstmt = con.prepareStatement(INSERT_RECORD);
    pstmt.setDate(1, previsao); //seta primeira ?
    pstmt.setString(2,Nome);  //seta segunda ?
    
    pstmt.executeUpdate();//coloca a statement insery_record em executeUpdate para atualizar o valor
    
    stm.execute("SHUTDOWN");
    }catch(ClassNotFoundException e){
    System.out.println("Erro ao carregar o driver JDBC. ");
    }catch(SQLException e){
    System.out.println("Erro de SQL: "+e);    
    }
    }
    
    //insere no banco de dados o objeto morador na tabela morador
    public static void insere(Morador m,int linha){
    String nome,genero;
    Date data1,data2,data3,ano;
    try{
    Class.forName("org.hsqldb.jdbcDriver"); //acessa driver do banco de dados
    //estabelece conexão com o baco de dados
    Connection con = DriverManager.getConnection("jdbc:hsqldb:file:C:\\Users\\rafae\\Downloads\\Unesp\\LCP\\Projeto-LCP\\Banco de Dados\\BD", "sa", ""); //CAMPOS UR/Login/senha
    Statement stm= con.createStatement(); //criada instancia para trabalhar com instruções do banco de dados
    nome = m.getNome();
    genero = m.getGenero();
    data1 = (Date) m.getData_nascimento();
    ano = (Date) m.getAno_ingresso();
    data2 = (Date) m.getPrevisao_saida();
    data3 = (Date) m.getData_saida(); 
    //Cria a statement para inserir os campos de Morador
    String INSERT_RECORD;
    INSERT_RECORD = "insert into Morador (LINHA,NOME,GENERO,DATA_NASCIMENTO,ANO_INGRESSO,PREVISAO_SAIDA,DATA_SAIDA) VALUES(?,?,?,?,?,?,?)";
    PreparedStatement pstmt = con.prepareStatement(INSERT_RECORD);
    pstmt.setInt(1, linha); // seta primeira ?
    pstmt.setString(2, nome);
    pstmt.setString(3, genero);
    pstmt.setDate(4, data1);
    pstmt.setDate(5, ano);
    pstmt.setDate(6, data2);
    pstmt.setDate(7, data3);
    
    pstmt.executeUpdate();//coloca a statement insery_record em executeUpdate para atualizar o valor
    // Mostra os resultados de todos os campos selecionados
    ResultSet rs;
    rs = stm.executeQuery("SELECT * FROM Morador");
    while(rs.next()){
        nome = rs.getString("nome");
        genero = rs.getString("genero");
        int i = rs.getInt("linha");
        data1 = rs.getDate("data_nascimento");
        ano = rs.getDate("data_nascimento");
        data2 = rs.getDate("data_nascimento");
        data3 = rs.getDate("data_nascimento");
        System.out.println(nome + genero + i + data1 + ano + data2 + data3);
    }
    // necessario para desligar o banco de dados e salvar os dados inseridos
    stm.execute("SHUTDOWN");
}catch(ClassNotFoundException e){
    System.out.println("Erro ao carregar o driver JDBC. ");
}catch(SQLException e){
    System.out.println("Erro de SQL: "+e);
}
    }
    public static void main(String[] args){
    int linha = 1; //conta quantas inserções foram feitas
    //coloca valor em dados
    Date data1 = new Date(1950,04,03);
    Date ano = new Date (1979,01,01);
    Date data2 = new Date(1980,11,05);
    Date data3 = new Date(1900,05,05);
    Morador m1 = new Morador("Rafael Watanabe","Masculino",data1,ano,data2,data3);
    insere(m1,linha);
    update_previsao_saida(data3,"William Watanabe");
    linha++;
   }     
}