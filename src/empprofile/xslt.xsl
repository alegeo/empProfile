<?xml version="1.0"?>
<app:stylesheet xmlns:xsl='http://www.w3.org/1999/XSL/Transform' version="1.0"
                  xmlns:apcv='http://namespace.profile.com/ns/cv'
                  xmlns:com='http://namespace.profile.com/ns/com'
                  xmlns:t='http://namespace.profile.com/ns/transcript'
                  xmlns:e='http://namespace.profile.com/ns/empRecord'
                  xmlns:app='http://namespace.profile.com/ns/profile'
                  app:schemaLocation='http://namespace.profile.com/profile profile.xsd'>
                      
<xsl:output method="xml" />
<xsl:variable name="empRecord" select="document('empRecord.xml')/e:empRecord"/>
<xsl:variable name="companyInfo" select="document('companyInfo.xml')/com:companyInfo/com:companies"/>
<xsl:variable name="transcript" select="document('transcript.xml')/t:transcript"/> 

    <xsl:template match="apcv:cv" > 
            <app:profile>
                <app:cv_info>
                <app:name><xsl:value-of select="apcv:name" /> </app:name>
                <app:address><xsl:value-of select="apcv:address" /> </app:address>
                <app:telephone><xsl:value-of select="apcv:telephone" /> </app:telephone>
                <app:email><xsl:value-of select="apcv:email" /></app:email>
                <app:education><xsl:value-of select="apcv:education" /> </app:education>
               <app:education>
                    <app:univeirsity><xsl:value-of select="$transcript/t:university"/></app:univeirsity>
                    <app:program><xsl:value-of select="$transcript/t:program"/></program><app:GPA> 
                    <!-- <xsl:value-of select=" (4*(sum($transcript/courses/course[grade='A']/credits)) + 3*(sum($transcript/courses/course[grade='B']/credits)) + 2*(sum($transcript/courses/course[grade='C']/credits)) + 1*(sum($transcript/courses/course[grade='D']/credits))) div (sum($transcript/courses/course/credits))"/>  -->
                    <app:xsl:value-of select="format-number( (4*(sum($transcript/t:courses/t:course[t:grade='A']/t:credits)) + 3*(sum($transcript/t:courses/t:course[t:grade='B']/t:credits)) + 2*(sum($transcript/t:courses/t:course[t:grade='C']/t:credits)) + 1*(sum($transcript/t:courses/t:course[t:grade='D']/t:credits))) div (sum($transcript/t:courses/t:course/t:credits)), '#.000')"/>
                    </app:GPA> 
                    </app:education>
                <xsl:for-each select="apcv:language"> 
                        <app:language> <xsl:value-of select="." /></app:language>
                </xsl:for-each>
                <app:qualifications><xsl:value-of select="apcv:qualifications" /></app:qualifications>
                <app:jobType><xsl:value-of select="apcv:jobType" /></app:jobType>
                <app:desiredPosition><xsl:value-of select="apcv:desiredPosition" /></app:desiredPosition>
                <app:references><xsl:value-of select="apcv:references" /> </app:references>
                <app:motivation><xsl:value-of select="apcv:motivation" /> </app:motivation>
                </app:cv_info>
                
                <xsl:variable name="companyWorked" select="$empRecord/e:companyWorked/e:workedAtComId"/>
                <xsl:for-each select="$empRecord/e:companyWorked">
                <app:companyWorked>  
                    <app:workedAtId><xsl:value-of select="./e:workedAtComId"/></app:workedAtComId>
                    <app:companyAtComId><xsl:value-of select="./e:workedAt"/></app:workedAt>  
                    <app:duration><xsl:value-of select="$empRecord/e:companyWorked/e:duration"/></app:duration>
                    <app:year><xsl:value-of select="$empRecord/e:companyWorked/e:year"/></yearapp:>
                     <app:position><xsl:value-of select="$empRecord/e:companyWorked/e:position"/></app:position>
                </app:companyWorked>
                </xsl:for-each>
                    
                <xsl:for-each select="$companyInfo/*/com:companyId">
                <xsl:choose>
                <xsl:when test=". = $companyWorked">
                <app:companyInfo> 
                   <app:name><xsl:value-of select="../com:companyName"/></app:name>
                   <app:category><xsl:value-of select="../com:category"/></app:category>
                   <app:founders><xsl:value-of select="../com:founders"/></app:founders>
                   <app:ceo><xsl:value-of select="../com:ceo"/></app:ceo>
                   <app:location><xsl:value-of select="../com:location"/></app:location>
                   <app:contact><xsl:value-of select="../com:contact"/></app:contact>
                </app:companyInfo> 
                </xsl:when>
                <xsl:otherwise />
                </xsl:choose>    
                </xsl:for-each> 
        </app:profile>
    </xsl:template>
        	
</xsl:stylesheet>	