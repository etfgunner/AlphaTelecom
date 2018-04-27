using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;

namespace Telecom.Models
{
    public class Problem
    {
        private int id;
        private DateTime dateInitiated;
        private string content;
        private int priority;
        private string userReported;
        private string category;

        public Problem()
        {
        }

        public Problem(DateTime dateInitiated, string content, int priority, string userReported, string category)
        {
            this.dateInitiated = dateInitiated;
            this.content = content;
            this.priority = priority;
            this.userReported = userReported;
            this.category = category;
        }

        public int Id { get => id; set => id = value; }
        public DateTime DateInitiated { get => dateInitiated; set => dateInitiated = value; }
        public string Content { get => content; set => content = value; }
        public int Priority { get => priority; set => priority = value; }
        public string Category { get => category; set => category = value; }
        public string UserReported { get => userReported; set => userReported = value; }

        //korisnik id;
    }
}