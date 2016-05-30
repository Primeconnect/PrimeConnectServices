package primeconnect.service;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.persistence.*;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Path("/entitygen")
public class EntityGenerator {

    private final static Logger logger = LogManager.getLogger();

//	@Inject
//	IProfessionalBO bo;

    @PersistenceContext(unitName = "hbMysqlPU",type = PersistenceContextType.TRANSACTION)
    private EntityManager entityManager;

    @GET
//    @Produces(MediaType.APPLICATION_JSON)
    public Response generate(@QueryParam("table") String table)
    {
        StringBuilder sb = new StringBuilder();

        Set<Object> typeSet = new HashSet<>();

//        List<String> tableList = entityManager.createNativeQuery("show tables").getResultList();
//        for (String table : tableList) {
//            logger.info("table : "+table);

//        String table = "PC_ADDRESS";


        StringBuilder curSb = new StringBuilder();
        curSb.append("package primeconnect.dao.entity;").append("\n\n");
        curSb.append("import javax.persistence.Column;").append("\n");
        curSb.append("import javax.persistence.Entity;").append("\n");
//        curSb.append("import javax.persistence.EntityResult;").append("\n");
        curSb.append("import javax.persistence.GeneratedValue;").append("\n");
        curSb.append("import javax.persistence.GenerationType;").append("\n");
        curSb.append("import javax.persistence.Id;").append("\n");
        curSb.append("import java.util.Date;").append("\n");
//        curSb.append("import javax.persistence.NamedNativeQuery;").append("\n");
//        curSb.append("import javax.persistence.SqlResultSetMapping;").append("\n\n");
        curSb.append("\n");
        curSb.append("@Entity(name=\""+table+"\")").append("\n");

        String className = getClassName(table);

        curSb.append("public class "+className+" {").append("\n\n");

//        curSb.append(" } ").append("\n");


        List<Object[]> columnList = entityManager.createNativeQuery("SHOW COLUMNS FROM "+table).getResultList();
        for ( Object[] objArr : columnList) {
            String colName = (String)objArr[0];
            String typeName = (String)objArr[1];
            String extra = (String)objArr[5];

            typeSet.add(objArr[1]);

//            logger.info("column: "+colName);

            if( "auto_increment".equalsIgnoreCase(extra) )
                curSb.append("@Id").append("\n").append("@GeneratedValue(strategy=GenerationType.IDENTITY)").append("\n");

            curSb.append("@Column(name=\"" + colName + "\")").append("\n");
            curSb.append("private "+getDatatype(typeName)+" "+getProperty(colName)+";").append("\n\n");
        }

        sb.append(curSb.toString());

//        }
//
//        for (Object o : typeSet) {
//            logger.info("Types: "+o.getClass()+" - "+o);
//        }

//        logger.info(sb.toString());

        return Response.ok(sb.toString()).type(MediaType.TEXT_PLAIN_TYPE).build();
    }

    private String getClassName(String table) {
        String className = "";
        String trimTable = ( table.toLowerCase().startsWith("pc_") ? table.toLowerCase().substring(3) : table.toLowerCase() );
        String[] split = trimTable.split("_");
        for (int i = 0; i < split.length; i++) {
            className += Character.toUpperCase(split[i].charAt(0))+split[i].substring(1);
        }
        return className;
    }

    private String getProperty(String colName) {
        String propertyName = "";
        String trimTable = ( colName.toLowerCase().startsWith("pc_") ? colName.toLowerCase().substring(3) : colName.toLowerCase() );
        String[] split = trimTable.split("_");
        for (int i = 0; i < split.length; i++) {
            if( i==0 )
                propertyName += split[i];
            else
                propertyName += Character.toUpperCase(split[i].charAt(0))+split[i].substring(1);
        }
        return propertyName;
    }

    private String getDatatype(String dbType) {
        if( dbType.toLowerCase().startsWith("varchar") )
            return "String";
        else if( dbType.toLowerCase().startsWith("int") )
            return "Integer";
        else if( dbType.toLowerCase().startsWith("bigint") )
            return "Long";
        else if( dbType.toLowerCase().equals("char(1)") )
            return "Character";
        else if( dbType.toLowerCase().equals("datetime") )
            return "Date";
        else
            return "";
    }

}
