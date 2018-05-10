using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;

namespace Telecom.Models
{
    public class ProblemRecord
    {
        private int id;
        private Problem problem;
        private DateTime dateCreated;
        private string personInCharge;
        private string description;

        public int Id { get => id; set => id = value; }
        public Problem Problem { get => problem; set => problem = value; }
        public DateTime DateCreated { get => dateCreated; set => dateCreated = value; }
        public string Description { get => description; set => description = value; }
        public string PersonInCharge { get => personInCharge; set => personInCharge = value; }

        public ProblemRecord(Problem problem, DateTime dateCreated, string personInCharge, string description)
        {
            this.problem = problem;
            this.dateCreated = dateCreated;
            this.personInCharge = personInCharge;
            this.description = description;
        }

        public ProblemRecord()
        {
        }

    }
}