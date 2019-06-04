/*
 * This Java source file was generated by the Gradle 'init' task.
 */
package edu.kit.datamanager.test;

import edu.kit.datamanager.entities.repo.Agent;
import edu.kit.datamanager.entities.repo.Box;
import edu.kit.datamanager.entities.repo.Contributor;
import edu.kit.datamanager.entities.repo.DataResource;
import edu.kit.datamanager.entities.repo.Date;
import edu.kit.datamanager.entities.repo.Description;
import edu.kit.datamanager.entities.repo.FunderIdentifier;
import edu.kit.datamanager.entities.repo.FundingReference;
import edu.kit.datamanager.entities.repo.GeoLocation;
import edu.kit.datamanager.entities.repo.Identifier;
import edu.kit.datamanager.entities.repo.Point;
import edu.kit.datamanager.entities.repo.Polygon;
import edu.kit.datamanager.entities.repo.PrimaryIdentifier;
import edu.kit.datamanager.entities.repo.RelatedIdentifier;
import edu.kit.datamanager.entities.repo.ResourceType;
import edu.kit.datamanager.entities.repo.Scheme;
import edu.kit.datamanager.entities.repo.Subject;
import edu.kit.datamanager.entities.repo.Title;
import edu.kit.datamanager.util.xml.DataCiteMapper;
import java.time.Instant;
import org.datacite.schema.kernel_4.Resource;
import org.junit.Test;

public class DataCiteMapperTest{

  @Test
  public void someStuffToDo() throws Exception{
    DataResource dataResource = new DataResource();
//
    PrimaryIdentifier id = new PrimaryIdentifier();
    id.setIdentifierType("DOI");
    id.setValue("test");
    dataResource.setIdentifier(id);
//
    Identifier alt = new Identifier();
    alt.setIdentifierType(Identifier.IDENTIFIER_TYPE.DOI);
    alt.setValue("altTest");
    dataResource.getAlternateIdentifiers().add(alt);
//
    RelatedIdentifier rel = new RelatedIdentifier();
    rel.setIdentifierType(RelatedIdentifier.RELATED_IDENTIFIER_TYPE.HANDLE);
    rel.setRelationType(RelatedIdentifier.RELATION_TYPES.DOCUMENTS);
    rel.setRelatedMetadataScheme("scheme1");
    rel.setValue("relatedDocument");
    Scheme s = new Scheme();
    s.setSchemeId("scheme1");
    s.setSchemeUri("http://heise.de");
    rel.setScheme(s);
    dataResource.getRelatedIdentifiers().add(rel);
///
    Agent a = new Agent();
    a.setGivenName("Thomas");
    a.setFamilyName("Jejkal");
    dataResource.getCreators().add(a);
//
    Title t = new Title();
    t.setLang("en");
    t.setTitleType(Title.TITLE_TYPE.SUBTITLE);
    t.setValue("This is the title");
    dataResource.getTitles().add(t);
//
    ResourceType type = new ResourceType();
    type.setTypeGeneral(ResourceType.TYPE_GENERAL.DATASET);
    type.setValue("Custom Dataset");
    dataResource.setResourceType(type);
//
    Contributor con = new Contributor();
    con.setUser(a);
    con.setContributionType(Contributor.CONTRIBUTOR_TYPE.DATA_COLLECTOR);
    dataResource.getContributors().add(con);
//
    Subject su = new Subject();
    su.setLang("en");
    su.setValue("My Subject");
    su.setValueUri("http://google.com");
    Scheme s2 = new Scheme();
    s2.setSchemeId("scheme2");
    s2.setSchemeUri("http://golem.de");
    su.setScheme(s2);
    dataResource.getSubjects().add(su);
//
    Date d = new Date();
    d.setType(Date.DATE_TYPE.ACCEPTED);
    d.setValue(Instant.now());
    dataResource.getDates().add(d);
//
    dataResource.getSizes().add("test");
    dataResource.getFormats().add("image/jpg");
//
    Description des = new Description();
    des.setLang("en");
    des.setDescription("This is the decriptions");
    des.setType(Description.TYPE.ABSTRACT);
    dataResource.getDescriptions().add(des);
// 
    Scheme rights = new Scheme();
    rights.setSchemeUri("http://apachecommons.org");
    rights.setSchemeId("Apache 2.0");
    dataResource.getRights().add(rights);
//
    FundingReference ref = new FundingReference();
    Scheme award = new Scheme();
    award.setSchemeId("awardId");
    award.setSchemeUri("http://bmbf.de");
    ref.setAwardNumber(award);
    ref.setFunderName("BMBF");
    ref.setAwardTitle("BMBF Award");
    FunderIdentifier fid = new FunderIdentifier();
    fid.setValue("BMBF");
    fid.setType(FunderIdentifier.FUNDER_TYPE.GRID);
    ref.setFunderIdentifier(fid);
    dataResource.getFundingReferences().add(ref);
//
    GeoLocation geo = new GeoLocation();
    Point po = new Point();
    po.setLatitude(1.0f);
    po.setLongitude(2.0f);
    geo.setPoint(po);
    geo.setPlace("Karlsruhe");

    Box box = new Box();
    box.setEastLongitude(0.0f);
    box.setNorthLatitude(1.0f);
    box.setSouthLatitude(2.0f);
    box.setWestLongitude(3.0f);
    geo.setBox(box);
    Polygon poly = new Polygon();
    Point p1 = new Point();
    p1.setLatitude(1.0f);
    p1.setLongitude(2.0f);
    Point p2 = new Point();
    p2.setLatitude(3.0f);
    p2.setLongitude(4.0f);
    Point p3 = new Point();
    p3.setLatitude(5.0f);
    p3.setLongitude(6.0f);
    poly.getPoints().add(p1);
    poly.getPoints().add(p2);
    poly.getPoints().add(p3);
    geo.setPolygon(poly);
    dataResource.getGeoLocations().add(geo);
    Resource resource = DataCiteMapper.dataResourceToDataciteResource(dataResource);

    //Implement checks later if required. For the moment, a successful mapping is good enough.
  }
}
