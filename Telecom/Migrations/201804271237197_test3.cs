namespace Telecom.Migrations
{
    using System;
    using System.Data.Entity.Migrations;
    
    public partial class test3 : DbMigration
    {
        public override void Up()
        {
            CreateTable(
                "dbo.ChangeRequests",
                c => new
                    {
                        Id = c.Int(nullable: false, identity: true),
                        ChangeDate = c.DateTime(nullable: false),
                        NewRequest_Id = c.Int(),
                        OldRequest_Id = c.Int(),
                    })
                .PrimaryKey(t => t.Id)
                .ForeignKey("dbo.Requests", t => t.NewRequest_Id)
                .ForeignKey("dbo.Requests", t => t.OldRequest_Id)
                .Index(t => t.NewRequest_Id)
                .Index(t => t.OldRequest_Id);
            
            CreateTable(
                "dbo.Requests",
                c => new
                    {
                        Id = c.Int(nullable: false, identity: true),
                        DateRequested = c.DateTime(nullable: false),
                        UserRequested = c.String(),
                        Status = c.String(),
                        Service_Id = c.Int(),
                    })
                .PrimaryKey(t => t.Id)
                .ForeignKey("dbo.Services", t => t.Service_Id)
                .Index(t => t.Service_Id);
            
            CreateTable(
                "dbo.Logs",
                c => new
                    {
                        Id = c.Int(nullable: false, identity: true),
                        DateCreated = c.DateTime(nullable: false),
                        Reason = c.String(),
                        Problem_Id = c.Int(),
                    })
                .PrimaryKey(t => t.Id)
                .ForeignKey("dbo.Problems", t => t.Problem_Id)
                .Index(t => t.Problem_Id);
            
            CreateTable(
                "dbo.Problems",
                c => new
                    {
                        Id = c.Int(nullable: false, identity: true),
                        DateInitiated = c.DateTime(nullable: false),
                        Content = c.String(),
                        Priority = c.Int(nullable: false),
                        Category = c.String(),
                        UserReported = c.String(),
                    })
                .PrimaryKey(t => t.Id);
            
            CreateTable(
                "dbo.ProblemClosures",
                c => new
                    {
                        Id = c.Int(nullable: false, identity: true),
                        DateClosed = c.DateTime(nullable: false),
                        Solved = c.Boolean(nullable: false),
                        Solution = c.String(),
                        Problem_Id = c.Int(),
                    })
                .PrimaryKey(t => t.Id)
                .ForeignKey("dbo.Problems", t => t.Problem_Id)
                .Index(t => t.Problem_Id);
            
        }
        
        public override void Down()
        {
            DropForeignKey("dbo.ProblemClosures", "Problem_Id", "dbo.Problems");
            DropForeignKey("dbo.Logs", "Problem_Id", "dbo.Problems");
            DropForeignKey("dbo.ChangeRequests", "OldRequest_Id", "dbo.Requests");
            DropForeignKey("dbo.ChangeRequests", "NewRequest_Id", "dbo.Requests");
            DropForeignKey("dbo.Requests", "Service_Id", "dbo.Services");
            DropIndex("dbo.ProblemClosures", new[] { "Problem_Id" });
            DropIndex("dbo.Logs", new[] { "Problem_Id" });
            DropIndex("dbo.Requests", new[] { "Service_Id" });
            DropIndex("dbo.ChangeRequests", new[] { "OldRequest_Id" });
            DropIndex("dbo.ChangeRequests", new[] { "NewRequest_Id" });
            DropTable("dbo.ProblemClosures");
            DropTable("dbo.Problems");
            DropTable("dbo.Logs");
            DropTable("dbo.Requests");
            DropTable("dbo.ChangeRequests");
        }
    }
}
